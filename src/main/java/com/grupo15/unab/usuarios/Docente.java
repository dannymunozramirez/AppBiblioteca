package com.grupo15.unab.usuarios;

/**
 * @author Grupo 15
 */
public class Docente extends Usuario {
    public Docente(String run, String tipo, String nombre, String genero, String prestamos, String gradoAcademico) {
        super(run, tipo, nombre, genero, prestamos);
        super.setGrado(gradoAcademico);
    }


}
