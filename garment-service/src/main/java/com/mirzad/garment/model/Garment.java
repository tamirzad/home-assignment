package com.mirzad.garment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.mirzad.garment.model.Publisher;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "garments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Garment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private GarmentType type;
    @Column(name = "description")
    private String description;
    private Publisher publisherId;
    @Column(name = "price")
    private Double price;
    @Column(name = "size")
    private GarmentSize size;
}
