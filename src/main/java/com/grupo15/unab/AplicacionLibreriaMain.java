package com.grupo15.unab;

import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.servicios.ServiciosDevolucion;

import com.grupo15.unab.servicios.ServiciosPrestamo;
import com.grupo15.unab.transacciones.Prestamo;
import com.grupo15.unab.usuarios.Docente;

import com.grupo15.unab.usuarios.Usuario;


import java.io.IOException;


/**
 * @author Grupo 15
 */
public class AplicacionLibreriaMain {

    public static void main(String[] args) throws IOException {
        Libro libroPrueba = new Libro("12777", "libro pal Danilo", "yo", "500", "400", "path");
        Usuario usuarioDocente3 = new Docente("9922222-8", "Docente", "Danilo", "f", "0", "magister");

        Prestamo prestamo1 = ServiciosPrestamo.generaUnArriendo(usuarioDocente3.getRun(), libroPrueba.getISBN());

        ServiciosDevolucion.devolverLibro(prestamo1);

    }

}
