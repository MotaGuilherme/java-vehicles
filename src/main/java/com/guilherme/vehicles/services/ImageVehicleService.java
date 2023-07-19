package com.guilherme.vehicles.services;

import com.guilherme.vehicles.entities.ImageVehicle;
import com.guilherme.vehicles.entities.Vehicles;
import com.guilherme.vehicles.repositories.ImageVehicleRepository;
import com.guilherme.vehicles.repositories.VehicleRepository;
import com.guilherme.vehicles.services.exceptions.ObjectNotFoundException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ImageVehicleService {

    @Autowired
    private ImageVehicleRepository imageVehicleRepository;

    @Autowired
    private VehicleRepository vehicleRepository;



    public ImageVehicle insert(Long idVehicle, MultipartFile file) {
        Vehicles vehicles = vehicleRepository.findById(idVehicle).get();
        ImageVehicle obj = new ImageVehicle();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String imageName = String.valueOf(vehicles.getId()) + file.getOriginalFilename();
                Path path = Paths.get("c:/images/" + imageName);
                Files.write(path, bytes);
                obj.setName(imageName);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        obj.setVehicles(vehicles);
        return imageVehicleRepository.save(obj);
    }

    public List<ImageVehicle> findAll() {
        return imageVehicleRepository.findAll();
    }

    public List<ImageVehicle> findImage(Long id) {
        List<ImageVehicle> listImages = imageVehicleRepository.findImageVehicleById(id);

        for (ImageVehicle imageVehicle : listImages) {
            try(InputStream in = new FileInputStream("c:/images/"+ imageVehicle.getName())) {
                imageVehicle.setArquivo(IOUtils.toByteArray(in));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return listImages;
    }

    public ImageVehicle update(ImageVehicle obj) {
        ImageVehicle newObj = findVehicleId(obj.getId());
        return imageVehicleRepository.save(newObj);
    }

    public void delete(Long id) {
        findVehicleId(id);
        try {
            imageVehicleRepository.deleteById(id);
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Its not possible delete a vehicle because its not found!");
        }
    }


    public ImageVehicle findVehicleId(Long id) {
        Optional<ImageVehicle> obj = imageVehicleRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Not found Object! Id: " + id ));
    }
}
