package com.grupo15.unab.transacciones;

import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.usuarios.Usuario;

import java.util.GregorianCalendar;
import java.util.List;


/**
 * @author Grupo 15
 */
public class Prestamo {

    // ISBN
    // LIBRO DEBE EXISTIR
    // LIBRO DEBE ESTAR DISPONIBLE
    // REGISTRAR RUN DEL USUARIO
    // RUN DEBE EXISTIR
    // EL USUARIO DEBE ESTAR HABILITADO PARA PRÉSTAMOS
    // UNA VEZ QUE SE CUMPLAN TODOS LOS PUNTOS ANTERIORES (USUARIO ARRIENDA UN LIBRO) EL USUARIO NO ESTARÁ
    // DISPONIBLE PARA ARRENDAR NUEVAMENTE CAMBIANDO EL ISBN DEL USUARIO AL ISBN DEL LIBRO QUE TOMÓ PRESTADO


    private Usuario usuario;
    private Libro libro;
    private Devolucion devolucion;
    private GregorianCalendar fecha;


    public Prestamo(Usuario usuario, Libro libro, GregorianCalendar fecha) {
        this.setUsuario(usuario);
        this.setLibro(libro);
        this.setFecha(fecha);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        // LLAMAR METODO QUE COMPRUEBA QUE EL USUARIOS EXISTE, SI EXISTE GUÁRDALO

        this.usuario = usuario;
    }

    public Libro getLibro() {
        // LLAMAR METODO QUE COMPRUEBA QUE EL LIBRO EXISTE
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Devolucion getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    static public void revisarRutUsuario(List<Usuario> usuario) {

    }
}
