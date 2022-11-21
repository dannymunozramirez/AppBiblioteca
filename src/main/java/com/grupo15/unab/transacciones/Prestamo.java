package com.grupo15.unab.transacciones;

import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.servicios.ServiciosLibro;
import com.grupo15.unab.servicios.ServiciosUsuarios;
import com.grupo15.unab.usuarios.Usuario;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * @author Grupo 15
 */
public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fecha;

    public Prestamo(Libro libro, Usuario usuario, LocalDate fecha) {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}

