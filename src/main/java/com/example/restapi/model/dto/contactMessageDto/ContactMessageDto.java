package com.example.restapi.model.dto.contactMessageDto;

public class ContactMessageDto {

    private Long id;
    private String authorName;
    private String email;
    private String phoneNumber;
    private String message;

    public ContactMessageDto() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public ContactMessageDto(Long id, String authorName, String email, String phoneNumber, String message) {
        this.id = id;
        this.authorName = authorName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public ContactMessageDto setId(Long id) {
        this.id = id;
        return this;
    }

    public ContactMessageDto setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactMessageDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ContactMessageDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ContactMessageDto setMessage(String message) {
        this.message = message;
        return this;
    }
}
