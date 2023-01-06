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
    private int periodo;
     @NotBlank
    private String detalles;
     @NotBlank
    private String estado;
     @NotBlank
    private String tituloEduc;

    public DtoEducation() {
    }

    public DtoEducation(String institucion, int periodo, String detalles, String estado, String tituloEduc) {
        this.institucion = institucion;
        this.periodo = periodo;
        this.detalles = detalles;
        this.estado = estado;
        this.tituloEduc = tituloEduc;
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
