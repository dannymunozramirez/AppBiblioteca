package com.grupo15.unab.transacciones;

import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.servicios.ServiciosLibro;
import com.grupo15.unab.servicios.ServiciosUsuarios;
import com.grupo15.unab.usuarios.Usuario;

import java.util.GregorianCalendar;
import java.util.List;


/**
 * @author Grupo 15
 */
public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private GregorianCalendar fecha;

    public Prestamo(Libro libro, Usuario usuario, GregorianCalendar fecha) {
        this.setLibro(libro);
        this.setUsuario(usuario);
        this.setFecha(fecha);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
}

