package com.mirzad.auth.client;


import com.mirzad.auth.dto.RegisterDto;
import com.mirzad.auth.dto.UserDto;
import com.mirzad.auth.request.RegisterRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", path = "/v1/user")
public interface UserServiceClient {
    @PostMapping()
    ResponseEntity<RegisterDto> save(@RequestBody RegisterRequest request);

    @GetMapping("/{username}")
    ResponseEntity<UserDto> getUserByUsername(@PathVariable String username);
}
