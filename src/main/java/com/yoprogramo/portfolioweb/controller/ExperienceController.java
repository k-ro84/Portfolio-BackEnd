/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.controller;

import com.yoprogramo.portfolioweb.dto.DtoExperience;
import com.yoprogramo.portfolioweb.entity.Experience;
import com.yoprogramo.portfolioweb.service.ServiceExperience;
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
@RequestMapping("/experience")
@CrossOrigin(origins="http://localhost:4200")
public class ExperienceController {
    
     @Autowired
     ServiceExperience serviceExperience;
     
     
      @GetMapping("/lista")
    public ResponseEntity<List <Experience>> list(){
        List<Experience> list = serviceExperience.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    
   @GetMapping("/detail/{id}")
   public ResponseEntity<Experience> getById(@PathVariable("id")int id){
      if(!serviceExperience.existsById(id)) {
          return new ResponseEntity(new Mensaje("ID invalid,please try again"),HttpStatus.OK);
      }
      
      Experience experience =serviceExperience.getOne(id).get();
        return new ResponseEntity(experience,HttpStatus.OK);
   
   }
   
   @PostMapping ("/create")
   public ResponseEntity <?> create(@RequestBody DtoExperience Dtoexperience){
       if(StringUtils.isBlank(Dtoexperience.getEmpresa())){
            return new ResponseEntity(new Mensaje("El nombre de la empresa/lugar de trabajo es obligatorio"),HttpStatus.OK);
       }
      Experience experience = new Experience(Dtoexperience.getEmpresa(),
             Dtoexperience.getPuesto(),
             Dtoexperience.getPeriodo(),
             Dtoexperience.getActividades());
         serviceExperience.save(experience);
          return new ResponseEntity(new Mensaje("Empresa/lugar de trabajo creada/o con exito!"),HttpStatus.OK);
   }
   
   @PutMapping ("/update/{id}")
     public ResponseEntity <?> update( @PathVariable("id")int id,@RequestBody DtoExperience Dtoexperience){
      if(!serviceExperience.existsById(id)) {
         return new ResponseEntity(new Mensaje("ID inexistente "),HttpStatus.NOT_FOUND);
      } 
       if(StringUtils.isBlank(Dtoexperience.getEmpresa())){
            return new ResponseEntity(new Mensaje("El nombre de la empresa/lugar de trabajo es obligatorio"),HttpStatus.OK);
       }
       Experience experience = serviceExperience.getOne(id).get();
             experience.setPuesto(Dtoexperience.getPuesto());
             experience.setPeriodo(Dtoexperience.getPeriodo());
              experience.setActividades(Dtoexperience.getActividades() );
         serviceExperience.save(experience);
          return new ResponseEntity(new Mensaje("empresa/lugar de trabajo actualizada/o!"),HttpStatus.OK);
     }
     
     
     @DeleteMapping ("/delete/{id}")
     public ResponseEntity <?> delete(@PathVariable("id")int id){
         if(!serviceExperience.existsById(id)) {
         return new ResponseEntity(new Mensaje("este ID no existe "),HttpStatus.NOT_FOUND);  
      
     }
         serviceExperience.delete(id);
         return new ResponseEntity(new Mensaje("empresa/lugar de trabajo eliminada/o"), HttpStatus.OK);
         
     }   
     
     
     
}
