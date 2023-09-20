package com.example.restapi.web;

import com.example.restapi.model.dto.userDto.EditUserDto;
import com.example.restapi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/editUser")
    public EditUserDto editUser(@RequestBody EditUserDto editUserDto) {
        return userService.editUser(editUserDto);
    }

    @GetMapping("/getUser/{id}")
    public EditUserDto getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);

    }
}
