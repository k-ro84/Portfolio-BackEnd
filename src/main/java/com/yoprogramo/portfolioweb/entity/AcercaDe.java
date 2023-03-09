/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class AcercaDe {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
  
    private String nombre;
   
    private String apellido;

    private String direccion;
    
    private String descripcion;
      @Size(max=250)
    private String imgUser;
   
    public AcercaDe() {
    }

    public AcercaDe(String nombre, String apellido, String direccion, String descripcion, String imgUser) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.imgUser = imgUser;
    }

   
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser;
    }

    
    
    
    
}
