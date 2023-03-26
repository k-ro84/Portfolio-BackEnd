/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.service;

import com.yoprogramo.portfolioweb.entity.Proyects;
import com.yoprogramo.portfolioweb.repository.ProyectsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ServiceProyects {
    
       @Autowired 
       ProyectsRepository proyectsRepository;
       
             
    public List<Proyects> list(){
        return proyectsRepository.findAll();
    }
    
    public Optional<Proyects> getOne(int id){
        return proyectsRepository.findById(id);
    }
    
     public Optional<Proyects> getByTituloProyecto(String tituloProyecto){
        return proyectsRepository.findByTituloProyecto(tituloProyecto);
    }
    
     public void save (Proyects proyects){
      proyectsRepository.save(proyects) ;
     }
     
     public boolean existsById(int id){
          return proyectsRepository.existsById(id);
     }
     
     public boolean existsByTituloProyecto(String tituloProyecto){
          return proyectsRepository.existsByTituloProyecto(tituloProyecto);
     }
       
       public void delete(int id) {
      proyectsRepository.deleteById(id);
     }   
       
    
}
