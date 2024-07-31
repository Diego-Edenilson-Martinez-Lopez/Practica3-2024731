package com.deml.PracticaDEML20240730.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "productos")
public class ProductoDEML {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    private String nombreDEML;

    @NotBlank(message = "La descripción es requerida")
    private String descripcionDEML;

    @NotNull(message = "El precio es requerido")
    private Double precioDEML;

    @NotNull(message = "La fecha de vencimiento es requerida")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVencimientoDEML;

    @NotNull(message = "El estatus es requerido")
    private Byte estatusDEML;

    @NotNull(message = "La existencia es requerida")
    private Integer existencia;


    public @NotBlank(message = "El nombre es requerido") String getNombreDEML() {
        return nombreDEML;
    }

    public void setNombreDEML(@NotBlank(message = "El nombre es requerido") String nombreDEML) {
        this.nombreDEML = nombreDEML;
    }

    public @NotBlank(message = "La descripción es requerida") String getDescripcionDEML() {
        return descripcionDEML;
    }

    public void setDescripcionDEML(@NotBlank(message = "La descripción es requerida") String descripcionDEML) {
        this.descripcionDEML = descripcionDEML;
    }

    public @NotNull(message = "El precio es requerido") Double getPrecioDEML() {
        return precioDEML;
    }

    public void setPrecioDEML(@NotNull(message = "El precio es requerido") Double precioDEML) {
        this.precioDEML = precioDEML;
    }

    public @NotNull(message = "La fecha de vencimiento es requerida") LocalDate getFechaVencimientoDEML() {
        return fechaVencimientoDEML;
    }

    public void setFechaVencimientoDEML(@NotNull(message = "La fecha de vencimiento es requerida") LocalDate fechaVencimientoDEML) {
        this.fechaVencimientoDEML = fechaVencimientoDEML;
    }

    public @NotNull(message = "El estatus es requerido") Byte getEstatusDEML() {
        return estatusDEML;
    }

    public void setEstatusDEML(@NotNull(message = "El estatus es requerido") Byte estatusDEML) {
        this.estatusDEML = estatusDEML;
    }

    public @NotNull(message = "La existencia es requerida") Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(@NotNull(message = "La existencia es requerida") Integer existencia) {
        this.existencia = existencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}