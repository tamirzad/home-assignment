package com.mirzad.garment.repository;

import com.mirzad.garment.model.Garment;
import com.mirzad.garment.model.GarmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GarmentRepository extends JpaRepository<Garment, Long> {

    @Query("SELECT g FROM Garment g WHERE (:type IS NULL OR g.type = :type) AND (:size IS NULL OR g.size = :size)")
    List<Garment> searchByTypeAndSize(@Param("type") GarmentType type, @Param("size") String size);

    @Override
    Optional<Garment> findById(Long aLong);
}
