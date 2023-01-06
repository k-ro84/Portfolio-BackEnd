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

@Entity
public class Education {
    
    @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @NotNull
    private String institucion;
    private int periodo;
    private String detalles;
    private String estado;
    private String tituloEduc;

    public Education() {
    }

    public Education(String institucion, int periodo, String detalles, String estado, String tituloEduc) {
        this.institucion = institucion;
        this.periodo = periodo;
        this.detalles = detalles;
        this.estado = estado;
        this.tituloEduc = tituloEduc;
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

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
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
    
    
    
}
