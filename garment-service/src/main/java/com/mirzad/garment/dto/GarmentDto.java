package com.mirzad.garment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mirzad.garment.model.GarmentSize;
import com.mirzad.garment.model.GarmentType;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GarmentDto {
    private GarmentType type;
    private String description;
    private Double price;
    private GarmentSize size;
}
