package com.mirzad.auth.request;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String username;
    private String password;
}
