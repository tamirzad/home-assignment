package com.mirzad.user_service.service;

import com.mirzad.user_service.exc.NotFoundException;
import com.mirzad.user_service.model.User;
import com.mirzad.user_service.model.UserRole;
import com.mirzad.user_service.repository.UserRepository;
import com.mirzad.user_service.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User saveUser(RegisterRequest request) {
        try {
            User user = getUserByUsername(request.getUsername());
        } catch (NotFoundException exception){
            User toSave = User.builder()
                    .username(request.getUsername())
                    .fullName(request.getFullName())
                    .address(request.getAddress())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(request.getRole() ==  null ? UserRole.USER : request.getRole()  )
                    .publisher(false)
                    .build();
            return userRepository.save(toSave);
        }

        throw new RuntimeException("User with this username already exists");
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

}
