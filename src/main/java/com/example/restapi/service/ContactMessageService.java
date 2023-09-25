package com.example.restapi.service;

import com.example.restapi.model.ContactMessageEntity;
import com.example.restapi.model.dto.contactMessageDto.ContactMessageDto;

import java.util.List;

public interface ContactMessageService {


    ContactMessageEntity sendMessage(ContactMessageDto message);
    List<ContactMessageEntity> getAllMessages();
    void deleteMessage(Long id);
}
