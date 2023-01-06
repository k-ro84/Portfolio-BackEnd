/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.dto;

import javax.validation.constraints.NotBlank;


public class DtoProyects {
    
    @NotBlank
    private String tituloProyecto;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String url;

    public DtoProyects() {
    }

    public DtoProyects(String tituloProyecto, String descripcion, String url) {
        this.tituloProyecto = tituloProyecto;
        this.descripcion = descripcion;
        this.url = url;
    }

    public String getTituloProyecto() {
        return tituloProyecto;
    }

    public void setTituloProyecto(String tituloProyecto) {
        this.tituloProyecto = tituloProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    
}
