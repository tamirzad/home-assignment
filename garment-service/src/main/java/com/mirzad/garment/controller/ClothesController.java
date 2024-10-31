package com.mirzad.garment.controller;

import com.mirzad.garment.model.Garment;
import com.mirzad.garment.model.GarmentType;
import com.mirzad.garment.repository.GarmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clothes")
@RequiredArgsConstructor
public class ClothesController {

    private final GarmentRepository garmentRepository;

    /**
     * Getting list of garments. Can be filtered by type and size
     * @param type - Type as param
     * @param size - Size as param
     * @return list of garments
     */
    @GetMapping
    public List<Garment> listGarments(
            @RequestParam(required = false) GarmentType type,
            @RequestParam(required = false) String size) {
        return garmentRepository.searchByTypeAndSize(type, size);
    }

    /**
     * Details for garment
     * @param id - id of garment
     * @return detailed garment
     */
    @GetMapping("/{id}")
    public Garment getGarmentById(@PathVariable Long id) {
        return garmentRepository.findById(id).orElse(null); // or throw an exception
    }

}
