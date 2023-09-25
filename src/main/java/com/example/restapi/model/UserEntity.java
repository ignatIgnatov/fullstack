package com.example.restapi.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private int age;
    private String gender;
    private String city;
    private String address;
    private String education;
    private String workplace;
    private String facebook;
    private String github;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "picture_id")
    private CloudinaryPictureEntity picture;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "image_id")
//    private ImageEntity image;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> authorities;

    public UserEntity() {
        super();
        this.authorities = new HashSet<>();
    }

    public UserEntity(String username, String password, Set<RoleEntity> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

//    public ImageEntity getImage() {
//        return image;
//    }
//
//    public UserEntity setImage(ImageEntity image) {
//        this.image = image;
//        return this;
//    }


    public CloudinaryPictureEntity getPicture() {
        return picture;
    }

    public UserEntity setPicture(CloudinaryPictureEntity picture) {
        this.picture = picture;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserEntity setAge(int age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserEntity setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public UserEntity setEducation(String education) {
        this.education = education;
        return this;
    }

    public String getWorkplace() {
        return workplace;
    }

    public UserEntity setWorkplace(String workplace) {
        this.workplace = workplace;
        return this;
    }

    public String getFacebook() {
        return facebook;
    }

    public UserEntity setFacebook(String facebook) {
        this.facebook = facebook;
        return this;
    }

    public String getGithub() {
        return github;
    }

    public UserEntity setGithub(String github) {
        this.github = github;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserEntity setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public UserEntity setAuthorities(Set<RoleEntity> authorities) {
        this.authorities = authorities;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
