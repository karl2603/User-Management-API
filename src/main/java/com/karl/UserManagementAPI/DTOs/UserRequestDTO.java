package com.karl.UserManagementAPI.DTOs;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    private String city;
}
