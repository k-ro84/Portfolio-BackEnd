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
public class Education {
    
    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String institucion;
    private String periodo;
    private String detalles;
    private String estado;
    private String tituloEduc;
    @Size(max=100)
    private String imagEstud;
    
    public Education() {
    }

    public Education(String institucion, String periodo, String detalles, String estado, String tituloEduc, String imagEstud) {
        this.institucion = institucion;
        this.periodo = periodo;
        this.detalles = detalles;
        this.estado = estado;
        this.tituloEduc = tituloEduc;
        this.imagEstud = imagEstud;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTituloEduc() {
        return tituloEduc;
    }

    public void setTituloEduc(String tituloEduc) {
        this.tituloEduc = tituloEduc;
    }

    public String getImagEstud() {
        return imagEstud;
    }

    public void setImagEstud(String imagEstud) {
        this.imagEstud = imagEstud;
    }
    
    
    
}
