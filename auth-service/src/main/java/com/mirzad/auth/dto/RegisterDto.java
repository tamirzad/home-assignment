package com.mirzad.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDto {
    private String username;
    private String fullName;
    private String address;
}
