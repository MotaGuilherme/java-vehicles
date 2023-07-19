package com.guilherme.vehicles.controllers;

import com.guilherme.vehicles.entities.Vehicles;
import com.guilherme.vehicles.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
@CrossOrigin("*")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
        public ResponseEntity<Vehicles> insert (@RequestBody Vehicles obj) {
            obj = vehicleService.insert(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).body(obj);
        }


    @GetMapping
    public ResponseEntity <List<Vehicles>> findAll() {
        List<Vehicles> list = vehicleService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vehicles> findByid(@PathVariable Long id) {
        Vehicles list = vehicleService.findBtyId(id);
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<Vehicles> update(@PathVariable Long id, @RequestBody Vehicles obj) {
        vehicleService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
