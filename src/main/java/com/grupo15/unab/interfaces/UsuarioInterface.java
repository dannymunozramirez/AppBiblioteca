package com.grupo15.unab.interfaces;

/**
 * @author Grupo 15
 */
public interface UsuarioInterface {

    void pedirLibro(Integer ISBN, String run);
    void devolverLibro();
    void crearUsuario();
    void borrarUsuario();
}
