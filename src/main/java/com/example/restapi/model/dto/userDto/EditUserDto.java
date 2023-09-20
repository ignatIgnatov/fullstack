package com.example.restapi.model.dto.userDto;

public class EditUserDto {

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

    public EditUserDto() {
    }

    public Long getId() {
        return id;
    }

    public EditUserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EditUserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EditUserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public EditUserDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public EditUserDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getCity() {
        return city;
    }

    public EditUserDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EditUserDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public EditUserDto setEducation(String education) {
        this.education = education;
        return this;
    }

    public String getWorkplace() {
        return workplace;
    }

    public EditUserDto setWorkplace(String workplace) {
        this.workplace = workplace;
        return this;
    }

    public String getFacebook() {
        return facebook;
    }

    public EditUserDto setFacebook(String facebook) {
        this.facebook = facebook;
        return this;
    }

    public String getGithub() {
        return github;
    }

    public EditUserDto setGithub(String github) {
        this.github = github;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public EditUserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EditUserDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
