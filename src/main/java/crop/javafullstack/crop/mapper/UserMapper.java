package crop.javafullstack.crop.mapper;

import crop.javafullstack.crop.Entity.User;
import crop.javafullstack.crop.dto.UserDto;
import crop.javafullstack.crop.dto.UserSignupDto;

public class UserMapper {
	
	// ✅ FOR SIGNUP
    public static User toEntity(UserSignupDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // later hash
        user.setPhone(dto.getPhone());
        user.setProfileImage(dto.getProfileImage());
        return user;
    }

	public static UserDto toDto(User user) {
	    UserDto dto = new UserDto();
	    dto.setId(user.getId());
	    dto.setName(user.getName());
	    dto.setEmail(user.getEmail());
	    dto.setPhone(user.getPhone());
	    dto.setProfileImage(user.getProfileImage());
	    // ❌ DO NOT set token here
	    return dto;
	}

	
	}


