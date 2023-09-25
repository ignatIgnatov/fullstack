package com.example.restapi.web;

import com.example.restapi.model.ContactMessageEntity;
import com.example.restapi.model.dto.userDto.UserDto;
import com.example.restapi.service.AdminService;
import com.example.restapi.service.ContactMessageService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final ContactMessageService contactMessageService;

    public AdminController(AdminService adminService, ContactMessageService contactMessageService) {
        this.adminService = adminService;
        this.contactMessageService = contactMessageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> allUsers() {

       return ResponseEntity.ok(adminService.getAllUsers());
   }


    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<UserDto> deleteUser(@PathVariable("id") Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/message/getAll")
    public ResponseEntity<List<ContactMessageEntity>> getAll() {
        return ResponseEntity.ok(contactMessageService.getAllMessages());
    }

    @DeleteMapping("/message/delete/{id}")
    @Transactional
    public ResponseEntity<ContactMessageEntity> deleteMessage(@PathVariable("id") Long id) {
        contactMessageService.deleteMessage(id);
        return ResponseEntity.ok().build();
    }
}
