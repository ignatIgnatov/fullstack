package com.example.restapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contact_messages")
public class ContactMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author_name")
    private String authorName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "message")
    private String message;

    public ContactMessageEntity() {
    }

    public ContactMessageEntity(Long id, String authorName, String email, String phoneNumber, String message) {
        this.id = id;
        this.authorName = authorName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public ContactMessageEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public ContactMessageEntity setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactMessageEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ContactMessageEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ContactMessageEntity setMessage(String message) {
        this.message = message;
        return this;
    }
}
