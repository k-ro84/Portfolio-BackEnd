/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.service;

import com.yoprogramo.portfolioweb.entity.AcercaDe;
import com.yoprogramo.portfolioweb.repository.AcercaDeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ServiceAcercaDe {
    
    @Autowired 
    AcercaDeRepository acercaDeRepository;
    
    public List<AcercaDe> list(){
        return acercaDeRepository.findAll();
    }
    
    public Optional<AcercaDe> getOne(int id){
        return acercaDeRepository.findById(id);
    }
    
     public Optional<AcercaDe> getByNombre(String nombre){
        return acercaDeRepository.findByNombre(nombre);
    }
    
     public void save (AcercaDe acercaDe){
      acercaDeRepository.save(acercaDe);
     }
     
     public boolean existsById(int id){
          return acercaDeRepository.existsById(id);
     }
     
     public boolean existsByNombre (String acercaDe){
          return acercaDeRepository.existsByNombre(acercaDe);
     }

    public void delete(int id) {
        acercaDeRepository.deleteById(id);
    }
}