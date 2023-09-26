package com.example.restapi.service.impl;

import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.model.UserEntity;
import com.example.restapi.model.dto.userDto.EditUserDto;
import com.example.restapi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return (userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    }

    public UserEntity editUser(EditUserDto editUserDto) {

        UserEntity user = userRepository.findById(editUserDto.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        user
                .setFirstName(editUserDto.getFirstName())
                .setLastName(editUserDto.getLastName())
                .setAge(editUserDto.getAge())
                .setGender(editUserDto.getGender())
                .setCity(editUserDto.getCity())
                .setAddress(editUserDto.getAddress())
                .setEducation(editUserDto.getEducation())
                .setWorkplace(editUserDto.getWorkplace())
                .setFacebook(editUserDto.getFacebook())
                .setGithub(editUserDto.getGithub());



        userRepository.save(user);
        return user;
    }

    public UserEntity getUser(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
