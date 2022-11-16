package com.grupo15.unab.clientes;

import com.grupo15.unab.usuarios.Usuario;
import com.grupo15.unab.validaciones.Servicios;

import java.util.List;

public class Clientes {

    List<Usuario> usuarios;

    public Clientes(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarUsuario(Usuario usuario) {

//        Validaciones.revisarRutUsuarioExiste(usuario, usuarios);
        if (!Servicios.revisarRutUsuarioExiste(usuario, usuarios)) {
            this.usuarios.add(usuario);
        } else {
            System.out.println("El USUARIO YA EXISTE!!!");
        }
        // Revisar que el usuario no exista en la lista
        System.out.println(Servicios.revisarRutUsuarioExiste(usuario, usuarios));

    }
}
