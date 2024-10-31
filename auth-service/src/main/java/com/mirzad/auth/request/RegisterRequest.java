package com.mirzad.auth.request;

import lombok.Getter;

@Getter
public class RegisterRequest {
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String role;
}
