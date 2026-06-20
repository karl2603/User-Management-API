package com.karl.UserManagementAPI.Service;

import com.karl.UserManagementAPI.DTOs.UserRequestDTO;
import com.karl.UserManagementAPI.DTOs.UserResponseDTO;
import com.karl.UserManagementAPI.Model.User;
import com.karl.UserManagementAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<UserResponseDTO> getAllUsers(){
        List<User> users = repository.findAll();
        List<UserResponseDTO> response = new ArrayList<>();
        for(int i=0; i<users.size(); i++){
            User user = users.get(i);
            UserResponseDTO dto = new UserResponseDTO();
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setPhoneNo(user.getPhoneNo());
            dto.setCity(user.getCity());
            dto.setAccountStatus(user.getAccountStatus());
            response.add(dto);
        }
        return response;
    }

    public UserResponseDTO getUser(int userId){
        User user = repository.findById(userId).orElse(null);
        if(user == null){
           return null;
        }
        UserResponseDTO response = new UserResponseDTO(user.getName(), user.getEmail(), user.getPhoneNo(), user.getCity(), user.getAccountStatus());
        return response;
    }

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
