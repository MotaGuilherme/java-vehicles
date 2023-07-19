package com.guilherme.vehicles.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guilherme.vehicles.entities.Vehicles;
import com.guilherme.vehicles.repositories.VehicleRepository;
import com.guilherme.vehicles.services.exceptions.DataIntegrityException;
import com.guilherme.vehicles.services.exceptions.ObjectNotFoundException;
import com.guilherme.vehicles.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Vehicles findBtyId(Long id) {
        return vehicleRepository.getReferenceById(id);
    }

    public Vehicles update(Long id, Vehicles obj) {
        findVehicleId(id);
        try {
            Vehicles entity = vehicleRepository.getReferenceById(id);
            updateData(entity, obj);
            return vehicleRepository.save(entity);

        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Its not possible delete a vehicle because its not found!" + id);
        }


    }

    public void delete(Long id) {
        findVehicleId(id);
        try {
            vehicleRepository.deleteById(id);
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Its not possible delete a vehicle because its not found!");
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Its not possible delete a vehicle thats have a image!");
        }
    }


    public Vehicles findVehicleId(Long id) {
        Optional<Vehicles> obj = vehicleRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Not found Object! Id: " + id ));
    }

    private void updateData(Vehicles entity, Vehicles obj) {
        entity.setName(obj.getName());
        entity.setBrand(obj.getBrand());
        entity.setModel(obj.getModel());
        entity.setPrice(obj.getPrice());
    }
}
