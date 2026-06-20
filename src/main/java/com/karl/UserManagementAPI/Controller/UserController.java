package com.karl.UserManagementAPI.Controller;

import com.karl.UserManagementAPI.DTOs.UserRequestDTO;
import com.karl.UserManagementAPI.DTOs.UserResponseDTO;
import com.karl.UserManagementAPI.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("users")
    public List<UserResponseDTO> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("userId") int userId) {
        UserResponseDTO response = service.getUser(userId);
        if(response == null){
            throw new NoSuchElementException();
        }
        else{
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("users/create")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequestDTO userRequest){
        service.createUser(userRequest);
        return new ResponseEntity<>("User Added", HttpStatus.CREATED);
    }
}
