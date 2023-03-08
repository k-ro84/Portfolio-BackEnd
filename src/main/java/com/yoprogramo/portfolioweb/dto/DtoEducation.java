/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.dto;

import javax.validation.constraints.NotBlank;


public class DtoEducation {
    
     @NotBlank
    private String institucion;
     @NotBlank
    private String periodo;
     @NotBlank
    private String detalles;
     @NotBlank
    private String estado;
     @NotBlank
    private String tituloEduc;
     @NotBlank
     private String imagEstud;

    public DtoEducation() {
    }

    public DtoEducation(String institucion, String periodo, String detalles, String estado, String tituloEduc, String imagEstud) {
        this.institucion = institucion;
        this.periodo = periodo;
        this.detalles = detalles;
        this.estado = estado;
        this.tituloEduc = tituloEduc;
        this.imagEstud = imagEstud;
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
