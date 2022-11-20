package com.grupo15.unab.usuarios;

import com.grupo15.unab.interfaces.UsuarioInterface;
import com.grupo15.unab.transacciones.Prestamo;

import java.util.List;

/**
 * @author Grupo 15
 */
public class Estudiante extends Usuario implements UsuarioInterface {

    public Estudiante(String run, String tipo, String nombre, String genero, String prestamos, String carrera) {
        super(run, tipo, nombre, genero, prestamos);
        super.setCarrera(carrera);
    }

    @Override
    public String toString() {
        return "Estudiante{} " + super.toString();
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


// go library
// check if the book is there
// borrow it or is not there
