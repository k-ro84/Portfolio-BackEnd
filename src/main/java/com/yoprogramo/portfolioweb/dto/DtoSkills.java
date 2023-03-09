/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.dto;

import javax.validation.constraints.NotBlank;


public class DtoSkills {
    
     @NotBlank
    private String tecnologia;
     @NotBlank
    private int porcentaje;

    public DtoSkills() {
    }

    public DtoSkills(String tecnologia, int porcentaje) {
        this.tecnologia = tecnologia;
        this.porcentaje = porcentaje;
    }

  

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

   
      
      
    
}
