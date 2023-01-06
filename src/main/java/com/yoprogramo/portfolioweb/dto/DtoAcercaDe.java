package com.yoprogramo.portfolioweb.dto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.validation.constraints.NotBlank;


public class DtoAcercaDe {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String direccion;
    @NotBlank
    private String descripcion;

    public DtoAcercaDe() {
    }

    public DtoAcercaDe(String nombre, String apellido, String direccion, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
