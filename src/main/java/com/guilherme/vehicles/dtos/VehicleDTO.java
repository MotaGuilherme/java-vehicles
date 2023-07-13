package com.guilherme.vehicles.dtos;

public class VehicleDTO {

    private Long id;
    private String name;
    private String brand;
    private String model;
   // private Byte imgCar;

    public VehicleDTO() {

    }

    public VehicleDTO(Long id, String name, String brand, String model) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.model = model;
        //this.imgCar = imgCar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

//    public Byte getImgCar() {
//        return imgCar;
//    }
//
//    public void setImgCar(Byte imgCar) {
//        this.imgCar = imgCar;
//    }
}
