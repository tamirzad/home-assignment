package com.mirzad.user_service.request;

import com.mirzad.common.model.UserRole;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RegisterRequest {
    @NotBlank(message = "Username is required")
    @Size(min = 6, message = "Username must be at least 6 characters")
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            message = "Password must be at least 8 characters and contain at least one letter and one number")
    @NotNull(message = "Password is required")
    private String password;
    private String fullName;
    private String address;
    private UserRole role;
}
