package com.guilherme.vehicles.repositories;

import com.guilherme.vehicles.entities.ImageVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageVehicleRepository extends JpaRepository<ImageVehicle, Long> {

    public List<ImageVehicle> findImageVehicleById(Long id);
}
