package com.example.restapi.model.dto.userDto;

import com.example.restapi.model.RoleEntity;

import java.util.Set;

public class LoginResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Set<RoleEntity> authorities;
    private String token;

    public LoginResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public LoginResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public LoginResponseDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public LoginResponseDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoginResponseDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LoginResponseDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<RoleEntity> getAuthorities() {
        return authorities;
    }

    public LoginResponseDto setAuthorities(Set<RoleEntity> authorities) {
        this.authorities = authorities;
        return this;
    }

    public String getToken() {
        return token;
    }

    public LoginResponseDto setToken(String token) {
        this.token = token;
        return this;
    }
}
