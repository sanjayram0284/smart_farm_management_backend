package crop.javafullstack.crop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crop.javafullstack.crop.dto.LoginDto;
import crop.javafullstack.crop.dto.UserDto;
import crop.javafullstack.crop.dto.UserSignupDto;
import crop.javafullstack.crop.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody UserSignupDto dto) {
        userService.signup(dto);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody LoginDto dto) {
        return userService.login(dto);
    }
}
