package com.mirzad.garment.dto;

import com.mirzad.garment.model.GarmentSize;
import com.mirzad.garment.model.GarmentType;
import lombok.Data;

@Data
public class GarmentDto {
    private GarmentType type;
    private String description;
    private Double price;
    private GarmentSize size;
}
