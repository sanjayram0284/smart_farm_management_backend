package crop.javafullstack.crop.service;

import org.springframework.web.multipart.MultipartFile;

import crop.javafullstack.crop.dto.LoginDto;
import crop.javafullstack.crop.dto.UserDto;
import crop.javafullstack.crop.dto.UserSignupDto;

public interface UserService {

    void signup(UserSignupDto dto);

    UserDto login(LoginDto dto);
    UserDto uploadProfileImage(String email, MultipartFile image);

	UserDto getUserByEmail(String email);
}
