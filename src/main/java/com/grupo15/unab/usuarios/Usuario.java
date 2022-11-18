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
    private String tipo;
    private String nombre;
    private String genero;
    private String grado;
    private String carrera;
    private Integer prestamos;

    public Usuario(String run, String tipo, String nombre, String genero, Integer prestamos) {
        this.run = run;
        this.tipo = tipo;
        this.nombre = nombre;
        this.genero = genero;
        this.prestamos = prestamos;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Integer getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Integer prestamos) {
        this.prestamos = prestamos;
    }
}
