package com.mirzad.user_service.dto;

import com.mirzad.common.model.UserRole;
import lombok.Data;

@Data
public class AuthUserDto {
    private String id;
    private String username;
    private String password;
    private UserRole role;
}