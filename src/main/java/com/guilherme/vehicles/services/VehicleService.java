package com.guilherme.vehicles.services;

import com.guilherme.vehicles.dtos.VehicleDTO;
import com.guilherme.vehicles.entities.Vehicles;
import com.guilherme.vehicles.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    public Vehicles insert(Vehicles obj) {
        obj.setId(null);
        return vehicleRepository.save(obj);
    }

    public List<Vehicles> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicles fromDTO(VehicleDTO objDto) {
        return new Vehicles(
                objDto.getId(),
                objDto.getName(),
                objDto.getBrand(),
                objDto.getModel());
                //objDto.getImgCar());
    }

}
