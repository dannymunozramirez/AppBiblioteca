package com.grupo15.unab.transacciones;

import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.usuarios.Usuario;

/**
 * @author Grupo 15
 */
public class Devolucion {
    private Prestamo prestamo;

    public Devolucion(Prestamo prestamo) {
        this.setPrestamo(prestamo);
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public String toString() {
        return "Devolucion{" +
                "prestamo=" + prestamo +
                '}';
    }
}
