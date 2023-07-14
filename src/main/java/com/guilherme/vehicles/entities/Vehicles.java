package com.guilherme.vehicles.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_vehicles")
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String model;
    private Integer price;

//    @Column(columnDefinition = "BYTEA")
//    private Byte imgCar;

    public Vehicles() {

    }

    public Vehicles(Long id, String name, String brand, String model, Integer price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;

       // this.imgCar = imgCar;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicles vehicles = (Vehicles) o;

        return id.equals(vehicles.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
