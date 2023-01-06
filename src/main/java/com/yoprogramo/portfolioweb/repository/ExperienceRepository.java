/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yoprogramo.portfolioweb.repository;


import com.yoprogramo.portfolioweb.entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository <Experience,Integer>{
    
     
    public Optional <Experience> findByEmpresa (String empresa);
    
    public boolean existsByEmpresa (String empresa);
    
}
