package com.karl.UserManagementAPI.Service;

import com.karl.UserManagementAPI.DTOs.UserRequestDTO;
import com.karl.UserManagementAPI.DTOs.UserResponseDTO;
import com.karl.UserManagementAPI.Model.User;
import com.karl.UserManagementAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public void createUser(UserRequestDTO userRequest){
        User newUser = new User();
        newUser.setName(userRequest.getName());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword(userRequest.getPassword());
        newUser.setPhoneNo(userRequest.getPhoneNo());
        newUser.setCity(userRequest.getCity());
        newUser.setRole("User");
        newUser.setAccountStatus("Active");
        repository.save(newUser);
    }
}
