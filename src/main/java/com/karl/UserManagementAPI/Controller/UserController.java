package com.karl.UserManagementAPI.Controller;

import com.karl.UserManagementAPI.DTOs.UserRequestDTO;
import com.karl.UserManagementAPI.DTOs.UserResponseDTO;
import com.karl.UserManagementAPI.Repository.UserRepository;
import com.karl.UserManagementAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("users/create")
    public void createUser(@RequestBody UserRequestDTO userRequest){
        service.createUser(userRequest);
    }
}
