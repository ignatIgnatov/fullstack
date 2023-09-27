package com.example.restapi.service.impl;

import com.example.restapi.model.ContactMessageEntity;
import com.example.restapi.model.dto.contactMessageDto.ContactMessageDto;
import com.example.restapi.repository.ContactMessageRepository;
import com.example.restapi.service.ContactMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContactMessageServiceImpl implements ContactMessageService {


    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageServiceImpl(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    @Override
    public ContactMessageEntity sendMessage(ContactMessageDto messageDto) {
        ContactMessageEntity message = new ContactMessageEntity();

        message
                .setAuthorName(messageDto.getAuthorName())
                .setEmail(messageDto.getEmail())
                .setPhoneNumber(messageDto.getPhoneNumber())
                .setMessage(messageDto.getMessage())
                .setCreated(LocalDate.now());


        contactMessageRepository.save(message);
        return message;
    }

    @Override
    public List<ContactMessageEntity> getAllMessages() {
        return contactMessageRepository.findAll();
    }

    @Override
    public void deleteMessage(Long id) {
        contactMessageRepository.deleteById(id);
    }
}
