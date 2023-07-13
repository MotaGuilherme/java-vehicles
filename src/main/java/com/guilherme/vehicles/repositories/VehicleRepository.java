package com.guilherme.vehicles.repositories;

import com.guilherme.vehicles.entities.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicles, Long> {

}
