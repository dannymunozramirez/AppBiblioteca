package com.grupo15.unab.usuarios;

import com.grupo15.unab.interfaces.UsuarioInterface;

/**
 * @author Grupo 15
 */
public class Docente extends Usuario implements UsuarioInterface {

    public Docente(String run, String tipo, String nombre, String genero, String prestamos, String gradoAcademico) {
        super(run, tipo, nombre, genero, prestamos);
        super.setGrado(gradoAcademico);
    }

    @Override
    public void pedirLibro(Integer ISBN, String run) {

    }

    @Override
    public void devolverLibro() {

    }

    @Override
    public void crearUsuario() {

    }

    @Override
    public void borrarUsuario() {

    }
}
