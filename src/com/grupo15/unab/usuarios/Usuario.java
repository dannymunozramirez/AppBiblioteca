package com.grupo15.unab.usuarios;

import com.grupo15.unab.transacciones.Prestamo;

import java.util.List;

/**
 * <p>
 * Esta clase es abstracta porque estamos evitando que sea instanciada
 * </p>
 *
 * @author Grupo 15
 */
abstract public class Usuario {

    private String run;
    private String nombre;
    private String genero;
    private List<Prestamo> prestamos;

    public Usuario(String run, String nombre, String genero) {
        this.run = run;
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Usuario(String run, String nombre, String genero, List<Prestamo> prestamos) {
        this.run = run;
        this.nombre = nombre;
        this.genero = genero;
        this.prestamos = prestamos;
    }
}
