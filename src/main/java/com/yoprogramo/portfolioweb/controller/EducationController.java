/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.controller;

import com.yoprogramo.portfolioweb.dto.DtoEducation;
import com.yoprogramo.portfolioweb.entity.Education;
import com.yoprogramo.portfolioweb.service.ServiceEducation;
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
@RequestMapping("/education")
@CrossOrigin(origins="*")
public class EducationController {
    
     @Autowired
     ServiceEducation serviceEducation;
     
    
     
      @GetMapping("/lista")
    public ResponseEntity<List <Education>> list(){
        List<Education> list = serviceEducation.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    
   @GetMapping("/detail/{id}")
   public ResponseEntity<Education> getById(@PathVariable("id")int id){
      if(!serviceEducation.existsById(id)) 
          return new ResponseEntity(new Mensaje("ID invalid,please try again"),HttpStatus.NOT_FOUND);
      
     Education education =serviceEducation.getOne(id).get();
        return new ResponseEntity(education,HttpStatus.OK);
   }
   
    @GetMapping("/detailname/{institucion}")
    public ResponseEntity<Education> getByNombre(@PathVariable("institucion") String institucion){
        if(!serviceEducation.existsByInstitucion(institucion))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Education education = serviceEducation.getByInstitucion(institucion).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
   
   
    
   @PostMapping("/create")
   public ResponseEntity <?> create(@RequestBody DtoEducation Dtoeducation){
       if(StringUtils.isBlank(Dtoeducation.getInstitucion()))
          return new ResponseEntity(new Mensaje("El nombre de la institucion/centro educativo es obligatorio"),HttpStatus.BAD_REQUEST);
        
       if(serviceEducation.existsByInstitucion(Dtoeducation.getInstitucion()))
            return new ResponseEntity(new Mensaje("nombre ya existente!!"),HttpStatus.BAD_REQUEST);
       
      Education education = new Education(Dtoeducation.getInstitucion(),
            Dtoeducation.getPeriodo(),
            Dtoeducation.getDetalles(),
            Dtoeducation.getEstado(),
            Dtoeducation.getTituloEduc(),
            Dtoeducation.getImagEstud());
         serviceEducation.save(education);
          return new ResponseEntity(new Mensaje("nivel educativo creado con exito!"),HttpStatus.OK);
   }
  
   @PutMapping("/update/{id}")
     public ResponseEntity <?> update( @PathVariable("id")int id,@RequestBody DtoEducation Dtoeducation){
      if(!serviceEducation.existsById(id)) 
         return new ResponseEntity(new Mensaje("ID inexistente "),HttpStatus.NOT_FOUND);
      
       if(StringUtils.isBlank(Dtoeducation.getInstitucion()))
            return new ResponseEntity(new Mensaje("El nombre de la institucion/centro educativo es obligatorio"),HttpStatus.OK);
       
       if(serviceEducation.existsByInstitucion(Dtoeducation.getInstitucion())&& 
               serviceEducation.getByInstitucion(Dtoeducation.getInstitucion()).get().getId()!=id)
         return new ResponseEntity(new Mensaje("nombre ya registrado/intente otro centro educativo"),HttpStatus.BAD_REQUEST);
      
       Education education = serviceEducation.getOne(id).get();
             education.setInstitucion(Dtoeducation.getInstitucion());
             education.setPeriodo(Dtoeducation.getPeriodo());
             education.setDetalles(Dtoeducation.getDetalles());
             education.setEstado(Dtoeducation.getEstado());
             education.setTituloEduc(Dtoeducation.getTituloEduc());
             education.setImagEstud(Dtoeducation.getImagEstud());
         serviceEducation.save(education);
          return new ResponseEntity(new Mensaje("Institucion/centro educativo actualizada/o!"),HttpStatus.OK);
     }
     
      
     @DeleteMapping("/delete/{id}")
     public ResponseEntity <?> delete(@PathVariable("id")int id){
         if(!serviceEducation.existsById(id)) 
         return new ResponseEntity(new Mensaje("este ID no existe "),HttpStatus.NOT_FOUND);  
      
         serviceEducation.delete(id);
         return new ResponseEntity(new Mensaje("Institucion/centro educativo eliminada/o"), HttpStatus.OK);
         
     }   
     
     
     
     
}
