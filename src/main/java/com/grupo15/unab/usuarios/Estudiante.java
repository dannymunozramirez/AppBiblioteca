package com.grupo15.unab.usuarios;


/**
 * @author Grupo 15
 */
public class Estudiante extends Usuario {

    public Estudiante(String run, String tipo, String nombre, String genero, String prestamos, String carrera) {
        super(run, tipo, nombre, genero, prestamos);
        super.setCarrera(carrera);
    }
}