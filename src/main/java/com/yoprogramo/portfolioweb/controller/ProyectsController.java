/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.controller;

import com.yoprogramo.portfolioweb.dto.DtoProyects;
import com.yoprogramo.portfolioweb.entity.Proyects;
import com.yoprogramo.portfolioweb.service.ServiceProyects;
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
@RequestMapping("/proyects")
@CrossOrigin(origins="http://localhost:4200")
public class ProyectsController {
    
     ServiceProyects serviceProyects;
     
     
     
      @GetMapping("/lista")
    public ResponseEntity<List <Proyects>> list(){
        List<Proyects> list = serviceProyects.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    
   @GetMapping("/detail/{id}")
   public ResponseEntity<Proyects> getById(@PathVariable("id")int id){
      if(!serviceProyects.existsById(id)) {
          return new ResponseEntity(new Mensaje("ID invalid,please try again"),HttpStatus.OK);
      }
      
     Proyects proyects =serviceProyects.getOne(id).get();
        return new ResponseEntity(proyects,HttpStatus.OK);
   
   }
   
   @PostMapping ("/create")
   public ResponseEntity <?> create(@RequestBody DtoProyects Dtoproyects){
       if(StringUtils.isBlank(Dtoproyects.getTituloProyecto())){
            return new ResponseEntity(new Mensaje("El nombre es obigatorio"),HttpStatus.OK);
       }
       Proyects proyects = new Proyects(Dtoproyects.getTituloProyecto(),
             Dtoproyects.getDescripcion() ,
             Dtoproyects.getUrl());
         serviceProyects.save(proyects);
          return new ResponseEntity(new Mensaje("Proyecto creado con exito!"),HttpStatus.OK);
   }
   
   @PutMapping ("/update/{id}")
     public ResponseEntity <?> update( @PathVariable("id")int id,@RequestBody DtoProyects Dtoproyects){
      if(!serviceProyects.existsById(id)) {
         return new ResponseEntity(new Mensaje("ID inexistente "),HttpStatus.NOT_FOUND);
      } 
       if(StringUtils.isBlank(Dtoproyects.getTituloProyecto())){
            return new ResponseEntity(new Mensaje("El nombre es obigatorio"),HttpStatus.OK);
       }
       Proyects proyects = serviceProyects.getOne(id).get();
             proyects.setTituloProyecto(Dtoproyects.getTituloProyecto()); ;
             proyects.setDescripcion(Dtoproyects.getDescripcion()); ;
             proyects.setUrl(Dtoproyects.getUrl()) ;
         serviceProyects.save(proyects);
          return new ResponseEntity(new Mensaje("Proyecto actualizado!"),HttpStatus.OK);
     }
     
     
     @DeleteMapping ("/delete/{id}")
     public ResponseEntity <?> delete(@PathVariable("id")int id){
         if(!serviceProyects.existsById(id)) {
         return new ResponseEntity(new Mensaje("este ID no existe "),HttpStatus.NOT_FOUND);  
      
     }
         serviceProyects.delete(id);
         return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
         
     }   
     
     
}
