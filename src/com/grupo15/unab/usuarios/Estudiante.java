package com.grupo15.unab.usuarios;

import com.grupo15.unab.interfaces.UsuarioInterface;
import com.grupo15.unab.transacciones.Prestamo;

/**
 * @author Grupo 15
 */
public class Estudiante extends Usuario implements UsuarioInterface {

    private String carrera;

    public Estudiante(String run, String nombre, String genero, Prestamo prestamo, String carrera) {
        super(run, nombre, genero, prestamo);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }


    @Override
    public String toString() {
        return "Estudiante{" +
                "carrera='" + carrera + '\'' +
                "} " + super.toString();
    }

    @Override
    public void pedirLibro(Integer ISBN, String run) {


    }

    @Override
    public void devolverLibro() {

    }
}


// go library
// check if the book is there
// borrow it or is not there
