package com.mirzad.garment.controller;

import com.mirzad.garment.dto.GarmentDto;
import com.mirzad.garment.repository.GarmentRepository;
import com.mirzad.garment.service.GarmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/garment")
@RequiredArgsConstructor
public class GarmentController {

    private final GarmentService garmentService;

    @PostMapping
    public void publishGarment(
            @RequestBody GarmentDto garmentDto,
            @RequestHeader(value = "Authorization", required = false) String authorization
    ){
        String jwt = null;

        if (authorization != null && authorization.startsWith("Bearer ")) {
            jwt = authorization.substring(7);
        }

        garmentService.save(garmentDto, jwt);
    }

    @DeleteMapping("/{garmentId}")
    public void deleteGarment(
            @PathVariable Long garmentId,
            @RequestHeader(value = "Authorization") String authorization
    ){
        String jwt = null;

        if (authorization != null && authorization.startsWith("Bearer ")) {
            jwt = authorization.substring(7);
        }

        garmentService.deleteGarmentById(garmentId, jwt);
    }


}
