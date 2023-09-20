package com.example.restapi.service;

import com.example.restapi.exception.UserExistException;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.model.dto.userDto.LoginDto;
import com.example.restapi.model.dto.userDto.LoginResponseDto;
import com.example.restapi.model.RoleEntity;
import com.example.restapi.model.UserEntity;
import com.example.restapi.model.dto.userDto.LogoutResponseDto;
import com.example.restapi.model.dto.userDto.RegistrationDto;
import com.example.restapi.repository.RoleRepository;
import com.example.restapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final ModelMapper modelMapper;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.modelMapper = modelMapper;
    }

    public UserEntity registerUser(RegistrationDto registrationDto) {

        if (userRepository.findByUsername(registrationDto.getUsername()).isPresent()) {
            throw new UserExistException("User already exist");
        }

        String encodedPassword = passwordEncoder.encode(registrationDto.getPassword());

        if (!passwordEncoder.matches(registrationDto.getConfirmPassword(), encodedPassword)) {
            throw new RuntimeException("Wrong password!");
        }

        if (roleRepository.count() == 0) {
            roleRepository.save(new RoleEntity("ADMIN"));
            roleRepository.save(new RoleEntity("USER"));
        }

        RoleEntity userRole = roleRepository.findByAuthority("USER").get();

        if (userRepository.count() == 0) {
            userRole = roleRepository.findByAuthority("ADMIN").get();
        }

        Set<RoleEntity> authorities = new HashSet<>();
        authorities.add(userRole);

        UserEntity user = modelMapper.map(registrationDto, UserEntity.class);

        user
                .setPassword(encodedPassword)
                .setAuthorities(authorities);

        return userRepository.save(user);
    }


    public LoginResponseDto loginUser(LoginDto loginDto) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
            );

            String token = tokenService.generateJwt(authentication);

            UserEntity user = userRepository.findByUsername(loginDto.getUsername())
                    .orElseThrow(() -> new UserNotFoundException("Invalid username or password"));
            LoginResponseDto dto = modelMapper.map(user, LoginResponseDto.class);
            dto.setToken(token);

            return dto;

        } catch (Exception e) {
            throw new UserNotFoundException("Invalid username or password");
        }
    }

    public LogoutResponseDto logout() {

        return new LogoutResponseDto();
    }
}
