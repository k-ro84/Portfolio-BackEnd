/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Admin implements UserDetails {

    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public Admin(String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    //lo creamos como una lista y convertimos la clase rol en grantedAuthority
    public static Admin build(Users users) {
        List<GrantedAuthority> authorities
                = users.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                .getRolNombre().name())).collect(Collectors.toList());
        return new Admin(users.getNombre(), users.getNombreUsuario(), users.getEmail(),
                users.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    //a estos booleanos se los considera: esta logeado si o no? por eso van como true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //credencial expirada??
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //esta habilitado??
    @Override
    public boolean isEnabled() {
        return true;
    }

    //estos se deben construir estos metodos no existen, por ello al hacer los primeros pasos no se crearon como los demas
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    //recordar para acomodar todo :boton der mouse-> darle a format y acomoda el codigo
}
