package com.example.restapi.service.impl;

import com.example.restapi.model.ContactMessageEntity;
import com.example.restapi.model.dto.contactMessageDto.ContactMessageDto;
import com.example.restapi.repository.ContactMessageRepository;
import com.example.restapi.service.ContactMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageServiceImpl implements ContactMessageService {


    private final ContactMessageRepository contactMessageRepository;
    private final ModelMapper modelMapper;

    public ContactMessageServiceImpl(ContactMessageRepository contactMessageRepository, ModelMapper modelMapper) {
        this.contactMessageRepository = contactMessageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ContactMessageEntity sendMessage(ContactMessageDto messageDto) {
        ContactMessageEntity message = new ContactMessageEntity();

        message
                .setAuthorName(messageDto.getAuthorName())
                .setEmail(messageDto.getEmail())
                .setPhoneNumber(messageDto.getPhoneNumber())
                .setMessage(messageDto.getMessage());

        return contactMessageRepository.save(message);
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
