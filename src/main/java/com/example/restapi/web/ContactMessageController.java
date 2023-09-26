package com.example.restapi.web;

import com.example.restapi.model.dto.contactMessageDto.ContactMessageDto;
import com.example.restapi.service.ContactMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/message")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping("/send")
    public ResponseEntity<?>  sendMessage(@RequestBody ContactMessageDto messageDto) {
        contactMessageService.sendMessage(messageDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
