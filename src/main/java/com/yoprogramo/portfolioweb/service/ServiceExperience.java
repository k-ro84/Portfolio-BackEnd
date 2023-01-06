/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.service;

import com.yoprogramo.portfolioweb.entity.Experience;
import com.yoprogramo.portfolioweb.repository.ExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 @Service
@Transactional
public class ServiceExperience {
    
        @Autowired 
        ExperienceRepository experienceRepository;
        

        
    public List<Experience> list(){
        return experienceRepository.findAll();
    }
    
    public Optional<Experience> getOne(int id){
        return experienceRepository.findById(id);
    }
    
     public Optional<Experience> getByEmpresa(String empresa){
        return experienceRepository.findByEmpresa(empresa);
    }
    
     public void save (Experience experience){
      experienceRepository.save(experience);
     }
     
     public boolean existsById(int id){
          return experienceRepository.existsById(id);
     }
     
     public boolean existsByEmpresa(String empresa){
          return experienceRepository.existsByEmpresa(empresa);
     }
            
      
    public void delete(int id) {
      experienceRepository.deleteById(id);
     }  
     
}
