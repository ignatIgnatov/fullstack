package com.example.restapi.service;

import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.model.UserEntity;
import com.example.restapi.model.dto.userDto.EditUserDto;
import com.example.restapi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, ModelMapper modelMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return (userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    }

    public EditUserDto editUser(EditUserDto editUserDto) {

        UserEntity user = userRepository.findById(editUserDto.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return modelMapper.map(user, EditUserDto.class);
    }

    public EditUserDto getUser(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return modelMapper.map(user, EditUserDto.class);
    }
}
