package com.guilherme.vehicles.dtos;

import com.guilherme.vehicles.entities.Vehicles;

public class VehicleDTO {

    private Long id;
    private String name;
    private String brand;
    private String model;
    private Integer price;

    // private Byte imgCar;

    public VehicleDTO() {

    }

    public VehicleDTO(Vehicles obj) {
        id = obj.getId();
        name = obj.getName();
        brand = obj.getBrand();
        model = obj.getModel();
        price = obj.getPrice();
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    //    public Byte getImgCar() {
//        return imgCar;
//    }
//
//    public void setImgCar(Byte imgCar) {
//        this.imgCar = imgCar;
//    }
}
