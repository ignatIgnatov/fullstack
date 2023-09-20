package com.example.restapi.web;

import com.example.restapi.model.dto.userDto.UserDto;
import com.example.restapi.service.AdminService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> allUsers() {

       return ResponseEntity.ok(adminService.getAllUsers());
   }


    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
