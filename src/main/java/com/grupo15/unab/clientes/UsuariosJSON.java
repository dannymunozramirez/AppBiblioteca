package com.grupo15.unab.clientes;

import com.grupo15.unab.usuarios.Usuario;
import com.grupo15.unab.servicios.Servicios;

import java.util.List;

public class UsuariosJSON {

    List<Usuario> usuarios;

    public UsuariosJSON(List<Usuario> usuarios) {
        //TODO
        // Cambiar a Set
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * <p>
     *
     * </p>
     * @param usuario
     */
    public void agregarUsuario(Usuario usuario) {

        if (!Servicios.revisarRutUsuarioExiste(usuario, usuarios)) {

            // TODO
            // Escribir en archivo JSON

            this.usuarios.add(usuario);
        } else {
            System.out.println("El USUARIO YA EXISTE!!!");
        }
    }
}
