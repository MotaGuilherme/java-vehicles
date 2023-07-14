package com.guilherme.vehicles.services;

import com.guilherme.vehicles.dtos.VehicleDTO;
import com.guilherme.vehicles.entities.Vehicles;
import com.guilherme.vehicles.repositories.VehicleRepository;
import com.guilherme.vehicles.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Vehicles update(Vehicles obj) {
        Vehicles newObj = findVehicleId(obj.getId());
        updateData(newObj, obj);
        return vehicleRepository.save(newObj);
    }

    public void delete(Long id) {
        findVehicleId(id);
        try {
            vehicleRepository.deleteById(id);
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Its not possible delete a vehicle because its not found!");
        }
    }


    public Vehicles findVehicleId(Long id) {
        Optional<Vehicles> obj = vehicleRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Not found Object! Id: " + id ));
    }

    public Vehicles fromDTO(VehicleDTO objDto) {
        return new Vehicles(
                objDto.getId(),
                objDto.getName(),
                objDto.getBrand(),
                objDto.getModel(),
                objDto.getPrice());
                //objDto.getImgCar());
    }

    private void updateData(Vehicles newObj, Vehicles obj) {
        newObj.setName(obj.getName());
        newObj.setBrand(obj.getBrand());
        newObj.setModel(obj.getModel());
        newObj.setPrice(obj.getPrice());
    }
}
