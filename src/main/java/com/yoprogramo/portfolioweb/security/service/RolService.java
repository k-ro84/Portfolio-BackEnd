/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.security.service;

import com.yoprogramo.portfolioweb.security.entity.Rol;
import com.yoprogramo.portfolioweb.security.enums.RolNombre;
import com.yoprogramo.portfolioweb.security.repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
//tran:lo que hace es que si algo falla haga un rollback y logra que no impacte en la base de datos para que se mantenga en un estado anterior
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        rolRepository.save(rol);
    }

}
