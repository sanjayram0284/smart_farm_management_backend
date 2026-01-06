package crop.javafullstack.crop.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import crop.javafullstack.crop.Entity.User;
import crop.javafullstack.crop.dto.LoginDto;
import crop.javafullstack.crop.dto.UserDto;
import crop.javafullstack.crop.dto.UserSignupDto;
import crop.javafullstack.crop.mapper.UserMapper;
import crop.javafullstack.crop.repository.UserRepository;
import crop.javafullstack.crop.security.JwtUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final Cloudinary cloudinary;

    @Override
    public void signup(UserSignupDto dto) {
        User user = UserMapper.toEntity(dto);
        userRepository.save(user);
    }

    @Override
    public UserDto login(LoginDto dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        UserDto userDto = UserMapper.toDto(user);
        userDto.setToken(token); // ✅ token here

        return userDto;
    }

    @Override
    public UserDto uploadProfileImage(String email, MultipartFile image) {
        try {
            Map uploadResult = cloudinary.uploader().upload(
                image.getBytes(),
                ObjectUtils.asMap("folder", "profiles")
            );

            String imageUrl = uploadResult.get("secure_url").toString();

            User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

            user.setProfileImage(imageUrl);
            userRepository.save(user);

            return UserMapper.toDto(user);

        } catch (Exception e) {
            throw new RuntimeException("Image upload failed");
        }
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserMapper.toDto(user);
    }

}
