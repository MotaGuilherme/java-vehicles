package com.guilherme.vehicles.controllers;

import com.guilherme.vehicles.dtos.VehicleDTO;
import com.guilherme.vehicles.entities.Vehicles;
import com.guilherme.vehicles.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody VehicleDTO objDto) {
        Vehicles obj = vehicleService.fromDTO(objDto);
        obj = vehicleService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> findAll() {
        List<Vehicles> list = vehicleService.findAll();
        List<VehicleDTO> listDto = list.stream().map(VehicleDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody VehicleDTO objDto, @PathVariable Long id) {
        Vehicles obj = vehicleService.fromDTO(objDto);
        obj.setId(id);
        vehicleService.update(obj);
        return ResponseEntity.noContent().build();
    }

}
