package com.grupo15.unab.interfaces;

/**
 * @author dannymunoz
 */
public interface UsuarioInterface {

    void pedirLibro(Integer ISBN, String run);
    void devolverLibro();
    void crearUsuario();
    void borrarUsuario();
}
