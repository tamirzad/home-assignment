package com.mirzad.garment.service;

import com.mirzad.garment.client.UserServiceClient;
import com.mirzad.garment.dto.GarmentDto;
import com.mirzad.garment.dto.UserDto;
import com.mirzad.garment.exc.NotFoundException;
import com.mirzad.garment.jwt.JwtUtil;
import com.mirzad.garment.model.Garment;
import com.mirzad.garment.model.User;
import com.mirzad.garment.repository.GarmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GarmentService {

    private final GarmentRepository garmentRepository;
    private final JwtUtil jwtUtil;
    private final UserServiceClient userServiceClient;

    public void save(GarmentDto garmentDto, String jwt){

        User user = getUserFromToken(jwt);
        user.setPublisher(true);

        Garment toSave = Garment.builder()
                .size(garmentDto.getSize())
                .type(garmentDto.getType())
                .price(garmentDto.getPrice())
                .publisherId(user)
                .description(garmentDto.getDescription())
                .build();

        garmentRepository.save(toSave);
    }

    public void deleteGarmentById(Long id, String jwt){
        User user = getUserFromToken(jwt);
        Garment garment = getGarmentById(id);

        if(!user.getId().equals(garment.getPublisherId().getId())) {
            throw new RuntimeException("User not allowed to delete this garment!");
        }

        garmentRepository.delete(garment);
    }

    public Garment getGarmentById(Long id){
        return garmentRepository.findById(id)
                .orElseThrow
                        (() -> new NotFoundException("User not found"));
    }

    private User getUserFromToken(String token){
        String username = null;

        if (token != null){
            username = jwtUtil.getClaims(token).getSubject();
        }

        return userServiceClient.getUserByUsername(username).getBody();
    }

}
