package crop.javafullstack.crop.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import crop.javafullstack.crop.dto.UserDto;
import crop.javafullstack.crop.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PostMapping(
        value = "/upload-profile",
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public UserDto uploadProfile(
            @RequestPart("image") MultipartFile image
    ) {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userService.uploadProfileImage(email, image);
    }
    @GetMapping("/me")
    public UserDto getCurrentUser() {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userService.getUserByEmail(email);
    }

}
