/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    
      @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String tecnologia;
    private long porcentaje;

    public Skills() {
    }

    public Skills(String tecnologia, long porcentaje) {
        this.tecnologia = tecnologia;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public long getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(long porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
