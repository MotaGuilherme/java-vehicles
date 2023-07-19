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

    @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity <ImageVehicle> insert (
                @RequestParam("idVehicle")
                Long idVehicle,
                @RequestParam("file")
                MultipartFile file) {

            ImageVehicle img = imageVehicleService.insert(idVehicle, file);
            return ResponseEntity.ok().body(img);
        }


    @GetMapping
    public ResponseEntity <List<ImageVehicle>> findAll() {
        List<ImageVehicle> list = imageVehicleService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <ImageVehicle> findById(@PathVariable Long id) {
        ImageVehicle list = imageVehicleService.findVehicleId(id);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "img/{id}")
    public ResponseEntity <List<ImageVehicle>> findImages(@PathVariable("id") Long idVehicle) {
        List<ImageVehicle> list = imageVehicleService.findImage(idVehicle);
        return ResponseEntity.ok().body(list);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        imageVehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ImageVehicle> update(@RequestBody ImageVehicle  obj, @PathVariable Long id) {
        ImageVehicle update = imageVehicleService.update(obj);
        return ResponseEntity.ok().body(update);
    }

}
