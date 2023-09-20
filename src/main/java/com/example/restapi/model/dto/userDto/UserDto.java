package com.example.restapi.model.dto.userDto;

import com.example.restapi.model.RoleEntity;

import java.util.Set;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String city;
    private String address;
    private String education;
    private String workplace;
    private String facebook;
    private String github;
    private String username;
    private String email;
    private Set<RoleEntity> authorities;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public UserDto setEducation(String education) {
        this.education = education;
        return this;
    }

    public String getWorkplace() {
        return workplace;
    }

    public UserDto setWorkplace(String workplace) {
        this.workplace = workplace;
        return this;
    }

    public String getFacebook() {
        return facebook;
    }

    public UserDto setFacebook(String facebook) {
        this.facebook = facebook;
        return this;
    }

    public String getGithub() {
        return github;
    }

    public UserDto setGithub(String github) {
        this.github = github;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<RoleEntity> getAuthorities() {
        return authorities;
    }

    public UserDto setAuthorities(Set<RoleEntity> authorities) {
        this.authorities = authorities;
        return this;
    }
}
