package com.grupo15.unab.usuarios;

import com.grupo15.unab.transacciones.Prestamo;

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
    private Prestamo prestamo;

    public Usuario(String run, String nombre, String genero, Prestamo prestamo) {
        this.run = run;
        this.nombre = nombre;
        this.genero = genero;
        this.prestamo = prestamo;
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


    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "run='" + run + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", prestamo=" + prestamo +
                '}';
    }
}
