package com.grupo15.unab.usuarios;

import com.grupo15.unab.interfaces.UsuarioInterface;

/**
 * @author Grupo 15
 */
public class Docente extends Usuario implements UsuarioInterface {

    private String gradoAcademico;

    public Docente(String run, String nombre, String genero, String gradoAcademico) {
        super(run, nombre, genero);
        this.gradoAcademico = gradoAcademico;
    }

    public String getGrado() {
        return gradoAcademico;
    }

    public void setGrado(String grado) {
        this.gradoAcademico = grado;
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

    @Override
    public String toString() {
        return "Docente{" + "gradoAcademico='" + gradoAcademico + '\'' + "} " + super.toString();
    }


}
