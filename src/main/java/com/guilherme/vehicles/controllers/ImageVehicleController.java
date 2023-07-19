package com.guilherme.vehicles.controllers;

import com.guilherme.vehicles.entities.ImageVehicle;
import com.guilherme.vehicles.entities.Vehicles;
import com.guilherme.vehicles.services.ImageVehicleService;
import com.guilherme.vehicles.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/imgVehicles")
public class ImageVehicleController {

    @Autowired
    private ImageVehicleService imageVehicleService;

    @PostMapping
        public ImageVehicle insert (
                @RequestParam("idVehicle")
                Long idVehicle,
                @RequestParam("file")
                MultipartFile file) {

            return imageVehicleService.insert(idVehicle, file);
        }


    @GetMapping
    public ResponseEntity <List<ImageVehicle>> findAll() {
        List<ImageVehicle> list = imageVehicleService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        imageVehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Void> update(@RequestBody VehicleDTO objDto, @PathVariable Long id) {
//        ImageVehicle obj = imageVehicleService.fromDTO(objDto);
//        obj.setId(id);
//        vehicleService.update(obj);
//        return ResponseEntity.noContent().build();
//    }

}
