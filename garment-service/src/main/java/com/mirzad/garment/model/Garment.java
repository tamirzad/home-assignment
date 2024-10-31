package com.mirzad.garment.model;


import com.mirzad.common.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private GarmentType type;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id" )
    private User publisherId;
    @Column(name = "price")
    private Double price;
    @Enumerated(EnumType.STRING)
    private GarmentSize size;
}
