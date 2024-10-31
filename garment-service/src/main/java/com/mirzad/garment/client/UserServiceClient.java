package com.mirzad.garment.client;


import com.mirzad.common.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", path = "/v1/user")
public interface UserServiceClient {

    @GetMapping("/{username}")
    ResponseEntity<User> getUserByUsername(@PathVariable String username);
}
