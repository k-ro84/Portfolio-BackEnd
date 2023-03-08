/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.security.service;

import com.yoprogramo.portfolioweb.security.entity.Users;
import com.yoprogramo.portfolioweb.security.repository.UsersRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersService {
    
    @Autowired
    UsersRepository usersRepository;
    
    public Optional<Users> getByNombreUsuario(String nombreUsuario){
        return usersRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usersRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usersRepository.existsByEmail(email);
    }

    public void save(Users users){
        usersRepository.save(users);
    }
    
}
