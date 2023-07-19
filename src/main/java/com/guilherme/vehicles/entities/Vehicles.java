package com.guilherme.vehicles.entities;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_vehicles")
@EqualsAndHashCode(of = "id")
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehicle;
    private String name;
    private String brand;
    private String model;
    private Double price;

    public Vehicles() {

    }

    public Vehicles(Long id_vehicle, String name, String brand, String model, Double price) {
        this.id_vehicle = id_vehicle;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id_vehicle;
    }

    public void setId(Long id) {
        this.id_vehicle = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

