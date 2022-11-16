package com.grupo15.unab.usuarios;

import com.grupo15.unab.interfaces.UsuarioInterface;
import com.grupo15.unab.transacciones.Prestamo;

import java.util.List;

/**
 * @author Grupo 15
 */
public class Estudiante extends Usuario implements UsuarioInterface {

    private String carrera;
    private List<Estudiante> estudiantes;


    public Estudiante(String run, String nombre, String genero, String carrera) {
        super(run, nombre, genero);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
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
