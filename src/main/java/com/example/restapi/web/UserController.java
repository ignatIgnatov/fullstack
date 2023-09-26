package com.example.restapi.web;

import com.example.restapi.model.UserEntity;
import com.example.restapi.model.dto.userDto.EditUserDto;
import com.example.restapi.service.impl.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/editUser")
    public UserEntity editUser(@RequestBody EditUserDto editUserDto) {
        return userService.editUser(editUserDto);
    }

    @GetMapping("/getUser/{id}")
    public UserEntity getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);

    }
}
