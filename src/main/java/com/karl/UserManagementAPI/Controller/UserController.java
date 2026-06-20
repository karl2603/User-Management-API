package com.karl.UserManagementAPI.Controller;

import com.karl.UserManagementAPI.DTOs.UserRequestDTO;
import com.karl.UserManagementAPI.DTOs.UserResponseDTO;
import com.karl.UserManagementAPI.Model.User;
import com.karl.UserManagementAPI.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<User> getUser(@PathVariable("userId") int userId){
        User user = service.getUser(userId);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @PostMapping("users/create")
    public void createUser(@Valid @RequestBody UserRequestDTO userRequest){
        service.createUser(userRequest);
    }
}
