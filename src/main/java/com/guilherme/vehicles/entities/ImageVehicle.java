package com.guilherme.vehicles.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_images")
//@EqualsAndHashCode(of = "id")
public class ImageVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_image;
    private String name;

    @ManyToOne
    @JoinColumn(name = "idVehicle")
    private Vehicles vehicles;

    @Transient
    private byte[] arquivo;

    public ImageVehicle() {

    }

    public ImageVehicle(Long id_image, String name, Vehicles vehicles) {
        this.id_image = id_image;
        this.name = name;
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id_image;
    }

    public void setId(Long id_image) {
        this.id_image = id_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }
}
