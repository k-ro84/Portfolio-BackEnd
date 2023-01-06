/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.service;
 
import com.yoprogramo.portfolioweb.entity.Skills;
import com.yoprogramo.portfolioweb.repository.SkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ServiceSkills {
    
       @Autowired 
       SkillsRepository skillsRepository;
        
    public List<Skills> list(){
        return skillsRepository.findAll();
    }
    
    public Optional<Skills> getOne(int id){
        return skillsRepository.findById(id);
    }
    
     public Optional<Skills> getByTecnologia(String tecnologia){
        return skillsRepository.findByTecnologia(tecnologia);
    }
    
     public void save (Skills skills){
      skillsRepository.save(skills);
     }
     
     public boolean existsById(int id){
          return skillsRepository.existsById(id);
     }
     
     public boolean existsByTecnologia(String tecnologia){
          return skillsRepository.existsByTecnologia(tecnologia);
     }
       
       public void delete(int id) {
      skillsRepository.deleteById(id);
     }  
       
       
}
