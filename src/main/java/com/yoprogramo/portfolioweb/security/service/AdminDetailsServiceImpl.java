/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.security.service;

import com.yoprogramo.portfolioweb.security.entity.Admin;
import com.yoprogramo.portfolioweb.security.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminDetailsServiceImpl implements UserDetailsService{
      
    @Autowired
    UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Users users = usersService.getByNombreUsuario(nombreUsuario).get();
        return Admin.build(users);
    }

    // le digo que construya mi admin a partir de los datos que ingrese de usuario
}
