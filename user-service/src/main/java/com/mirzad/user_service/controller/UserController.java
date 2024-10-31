package com.mirzad.user_service.controller;

import com.mirzad.user_service.dto.AuthUserDto;
import com.mirzad.user_service.dto.UserDto;
import com.mirzad.user_service.request.RegisterRequest;
import com.mirzad.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    /**
     * Endpoing for creating user
     * @param request - user we want to create
     * @return - created user
     */
    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(modelMapper.map(userService.saveUser(request), UserDto.class));
    }

    /**
     * Get user by its username
     * @param username - username of user
     * @return user details
     */
    @GetMapping("/{username}")
    public ResponseEntity<AuthUserDto> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(modelMapper.map(userService.getUserByUsername(username), AuthUserDto.class));
    }
}
