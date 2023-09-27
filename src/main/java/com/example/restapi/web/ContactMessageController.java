package com.example.restapi.web;

import com.example.restapi.model.ContactMessageEntity;
import com.example.restapi.model.dto.contactMessageDto.ContactMessageDto;
import com.example.restapi.service.ContactMessageService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/message")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping("/create")
    public ResponseEntity<ContactMessageEntity>  createMessage(@RequestBody ContactMessageDto messageDto) {
       ContactMessageEntity message =  contactMessageService.sendMessage(messageDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ContactMessageEntity>> getAll() {
        return ResponseEntity.ok(contactMessageService.getAllMessages());
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<ContactMessageEntity> deleteMessage(@PathVariable("id") Long id) {
        contactMessageService.deleteMessage(id);
        return ResponseEntity.ok().build();
    }
}
