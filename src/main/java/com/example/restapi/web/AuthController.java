package com.example.restapi.web;

import com.example.restapi.model.dto.userDto.LoginDto;
import com.example.restapi.model.dto.userDto.LoginResponseDto;
import com.example.restapi.model.dto.userDto.LogoutResponseDto;
import com.example.restapi.model.dto.userDto.RegistrationDto;
import com.example.restapi.model.UserEntity;
import com.example.restapi.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody RegistrationDto registrationDto) {
        return authService.registerUser(registrationDto);
    }

    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody LoginDto loginDto) {
        return authService.loginUser(loginDto);
    }


    @PostMapping("/logout")
    public LogoutResponseDto logout() {
        return authService.logout();
    }
}
