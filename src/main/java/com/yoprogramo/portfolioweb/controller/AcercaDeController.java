/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.controller;


import com.yoprogramo.portfolioweb.dto.DtoAcercaDe;
import com.yoprogramo.portfolioweb.entity.AcercaDe;
import com.yoprogramo.portfolioweb.service.ServiceAcercaDe;
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
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/acercaDe")
@CrossOrigin(origins = "*")
public class AcercaDeController {
   
    @Autowired
   ServiceAcercaDe serviceAcercaDe;
  
    
   @GetMapping("/lista")
    public ResponseEntity<List <AcercaDe>> list(){
        List<AcercaDe> list = serviceAcercaDe.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
 
    
   @GetMapping("/detail/{id}")
   public ResponseEntity<AcercaDe> getById(@PathVariable("id")int id){
      if(!serviceAcercaDe.existsById(id)) 
          return new ResponseEntity(new Mensaje("ID invalid,please try again."),HttpStatus.NOT_FOUND);
      
      AcercaDe acercaDe =serviceAcercaDe.getOne(id).get();
        return new ResponseEntity(acercaDe,HttpStatus.OK);
   
   }
   
  
   @GetMapping("/detailname/{nombre}")
    public ResponseEntity<AcercaDe> getByNombre(@PathVariable("nombre") String nombre){
        if(!serviceAcercaDe.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        AcercaDe acercaDe = serviceAcercaDe.getByNombre(nombre).get();
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }
   
    
    //  @PreAuthorize("hasRole('ADMIN')")
   @PostMapping("/create")
   public ResponseEntity <?> create(@RequestBody DtoAcercaDe DtoacercaDe){
       if(StringUtils.isBlank(DtoacercaDe.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
       
       if(serviceAcercaDe.existsByNombre(DtoacercaDe.getNombre()))
            return new ResponseEntity(new Mensaje("nombre ya existente"),HttpStatus.BAD_REQUEST);
       
       AcercaDe acercaDe = new AcercaDe(DtoacercaDe.getNombre(),
               DtoacercaDe.getApellido(),
               DtoacercaDe.getDireccion(),
               DtoacercaDe.getDescripcion(),
               DtoacercaDe.getImgUser());
         serviceAcercaDe.save(acercaDe);
          return new ResponseEntity(new Mensaje("Persona creada con exito!"),HttpStatus.OK);
   }
   
    // @PreAuthorize("hasRole('ADMIN')")
   @PutMapping("/update/{id}")
     public ResponseEntity <?> update( @PathVariable("id")int id,@RequestBody DtoAcercaDe DtoacercaDe){
      if(!serviceAcercaDe.existsById(id)) 
         return new ResponseEntity(new Mensaje("ID inexistente "),HttpStatus.NOT_FOUND);
      if(serviceAcercaDe.existsByNombre(DtoacercaDe.getNombre())&& 
               serviceAcercaDe.getByNombre(DtoacercaDe.getNombre()).get().getId()!=id)
         return new ResponseEntity(new Mensaje("nombre ya registrado/intente con otro"),HttpStatus.BAD_REQUEST);
        
       if(StringUtils.isBlank(DtoacercaDe.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.OK);
       
       AcercaDe acercaDe = serviceAcercaDe.getOne(id).get();
             acercaDe.setNombre(DtoacercaDe.getNombre());
             acercaDe.setApellido(DtoacercaDe.getApellido());
             acercaDe.setDireccion(DtoacercaDe.getDireccion());
             acercaDe.setDescripcion(DtoacercaDe.getDescripcion());
             acercaDe.setImgUser(DtoacercaDe.getImgUser());
         serviceAcercaDe.save(acercaDe);
          return new ResponseEntity(new Mensaje("Persona actualizada!"),HttpStatus.OK);
     }
     
     //  @PreAuthorize("hasRole('ADMIN')")
     @DeleteMapping("/delete/{id}")
     public ResponseEntity <?> delete(@PathVariable("id")int id){
         if(!serviceAcercaDe.existsById(id)) {
         return new ResponseEntity(new Mensaje("este ID no existe "),HttpStatus.NOT_FOUND);  
         }
         serviceAcercaDe.delete(id);
         return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
         
     }   
         
}
