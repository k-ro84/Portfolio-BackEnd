/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yoprogramo.portfolioweb.repository;


import com.yoprogramo.portfolioweb.entity.Proyects;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProyectsRepository extends JpaRepository <Proyects,Integer>{
    
     
    public Optional <Proyects> findByTituloProyecto (String tituloProyecto);
    
    public boolean existsByTituloProyecto (String tituloProyecto);
    
}
