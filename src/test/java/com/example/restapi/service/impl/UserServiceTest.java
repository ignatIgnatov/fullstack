package com.example.restapi.service.impl;

import com.example.restapi.model.RoleEntity;
import com.example.restapi.model.UserEntity;
import com.example.restapi.model.dto.userDto.EditUserDto;
import com.example.restapi.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserEntity testUser;
    private EditUserDto testUserDto;
    private RoleEntity adminRole, userRole;

    private UserService serviceToTest;
    private ModelMapper modelMapper;

    @Mock
    private UserRepository mockedUserRepository;

    @BeforeEach
    void init() {

        //ARRANGE

        serviceToTest = new UserService(mockedUserRepository, modelMapper);

        adminRole = new RoleEntity();
        adminRole.setAuthority("ADMIN");

        userRole = new RoleEntity();
        userRole.setAuthority("USER");

        testUser = new UserEntity()
                .setUsername("Ignat")
                .setEmail("ignat@abv.bg")
                .setPassword("123456")
                .setAuthorities(Set.of(adminRole, userRole));

        testUserDto = new EditUserDto()
                .setUsername("Ignat")
                .setEmail("ignat@abv.bg")
                .setAge(40)
                .setCity("Rousse")
                .setGender("Male");

    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("userNotFound"));
    }

    @Test
    void testUserFound() {

        //Arrange
        Mockito.when(mockedUserRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));

        //Act
        UserDetails actual = serviceToTest.loadUserByUsername(testUser.getUsername());

        String actualRoles = actual.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(", "));
        String expectedRoles = "USER, ADMIN";

        //Assert

        Assertions.assertEquals(actual.getUsername(), testUser.getUsername());
        Assertions.assertEquals(expectedRoles, actualRoles);

    }

    @Test
    void getUser() {

        Mockito.when(mockedUserRepository.findById(testUser.getUserId())).thenReturn(Optional.of(testUser));

        var actual = serviceToTest.getUser(testUser.getUserId());

        Assertions.assertEquals(actual.getUsername(), testUser.getUsername());
        Assertions.assertEquals(actual.getEmail(), testUser.getEmail());
    }

    @Test
    void userNotFoundByGetUserMethod() {
        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> serviceToTest.getUser(-1500L));
    }


    @Test
    void editUser() {
        Mockito.when(mockedUserRepository.findById(testUser.getUserId())).thenReturn(Optional.of(testUser));

        var actual = serviceToTest.editUser(testUserDto);

        Assertions.assertEquals(actual.getUsername(), testUserDto.getUsername());
        Assertions.assertEquals(actual.getAge(), testUserDto.getAge());
        Assertions.assertEquals(actual.getGender(), testUserDto.getGender());
    }
}
