package com.mirzad.auth.dto;

import com.mirzad.auth.service.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private Role role;
}
