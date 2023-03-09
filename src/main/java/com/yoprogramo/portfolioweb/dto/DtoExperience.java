/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.dto;

import javax.validation.constraints.NotBlank;


public class DtoExperience {
    
    @NotBlank
    private String empresa;
    @NotBlank
    private String puesto;
    @NotBlank
    private String periodo;
   @NotBlank
    private String actividades;

    public DtoExperience() {
    }

    public DtoExperience(String empresa, String puesto, String periodo, String actividades) {
        this.empresa = empresa;
        this.puesto = puesto;
        this.periodo = periodo;
        this.actividades = actividades;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }
    
    

    
}
