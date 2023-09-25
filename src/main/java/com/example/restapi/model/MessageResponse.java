package com.example.restapi.model;

public class MessageResponse {

    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse() {
    }

    public String getMessage() {
        return message;
    }

    public MessageResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
