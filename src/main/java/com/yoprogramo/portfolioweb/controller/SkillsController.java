/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.controller;

import com.yoprogramo.portfolioweb.dto.DtoSkills;
import com.yoprogramo.portfolioweb.entity.Skills;
import com.yoprogramo.portfolioweb.service.ServiceSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins="http://localhost:4200")
public class SkillsController {
    
     @Autowired
     ServiceSkills serviceSkills;
     
    
     
      @GetMapping("/lista")
    public ResponseEntity<List <Skills>> list(){
        List<Skills> list = serviceSkills.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    
   @GetMapping("/detail/{id}")
   public ResponseEntity<Skills> getById(@PathVariable("id")int id){
      if(!serviceSkills.existsById(id)) {
          return new ResponseEntity(new Mensaje("ID invalid,please try again"),HttpStatus.OK);
      }
      
      Skills skills =serviceSkills.getOne(id).get();
        return new ResponseEntity(skills,HttpStatus.OK);
   
   }
   
   @PostMapping ("/create")
   public ResponseEntity <?> create(@RequestBody DtoSkills Dtoskills){
       if(StringUtils.isBlank(Dtoskills.getTecnologia())){
            return new ResponseEntity(new Mensaje("nombre de Skill es obigatorio"),HttpStatus.OK);
       }
       Skills skills = new Skills(Dtoskills.getTecnologia(),
            Dtoskills.getPorcentaje() );
             
         serviceSkills.save(skills);
          return new ResponseEntity(new Mensaje("Skill creada con exito!"),HttpStatus.OK);
   }
   
   @PutMapping ("/update/{id}")
     public ResponseEntity <?> update( @PathVariable("id")int id,@RequestBody DtoSkills Dtoskills){
      if(!serviceSkills.existsById(id)) {
         return new ResponseEntity(new Mensaje("ID inexistente "),HttpStatus.NOT_FOUND);
      } 
       if(StringUtils.isBlank(Dtoskills.getTecnologia())){
            return new ResponseEntity(new Mensaje("nombre de Skill es obigatorio"),HttpStatus.OK);
       }
       Skills skills= serviceSkills.getOne(id).get();
             skills.setTecnologia(Dtoskills.getTecnologia());
             skills.setPorcentaje(Dtoskills.getPorcentaje());
             
         serviceSkills.save(skills);
          return new ResponseEntity(new Mensaje("Skill actualizada!"),HttpStatus.OK);
     }
     
    
     @DeleteMapping ("/delete/{id}")
     public ResponseEntity <?> delete(@PathVariable("id")int id){
         if(!serviceSkills.existsById(id)) {
         return new ResponseEntity(new Mensaje("este ID no existe "),HttpStatus.NOT_FOUND);  
      
     }
         serviceSkills.delete(id);
         return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
         
     }   
     
     
}
