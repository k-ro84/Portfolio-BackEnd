/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.service;

import com.yoprogramo.portfolioweb.entity.Education;
import com.yoprogramo.portfolioweb.repository.EducationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceEducation {
    
    
       @Autowired 
       EducationRepository educationRepository;
       
      
            
    public List<Education> list(){
        return educationRepository.findAll();
    }
    
    public Optional<Education> getOne(int id){
        return educationRepository.findById(id);
    }
    
     public Optional<Education> getByInstitucion(String institucion){
        return educationRepository.findByInstitucion(institucion);
    }
    
     public void save (Education education){
      educationRepository.save(education);
     }
     
     public boolean existsById(int id){
          return educationRepository.existsById(id);
     }
     
     public boolean existsByInstitucion(String institucion){
          return educationRepository.existsByInstitucion(institucion);
     }

    public void delete(int id) {
           educationRepository.deleteById(id);
        
       }
       
       
       
       
}
