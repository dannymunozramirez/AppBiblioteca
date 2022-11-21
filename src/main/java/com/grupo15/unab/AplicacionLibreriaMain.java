package com.grupo15.unab;

import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.servicios.ServiciosDevolucion;
import com.grupo15.unab.servicios.ServiciosLibro;
import com.grupo15.unab.servicios.ServiciosPrestamo;
import com.grupo15.unab.transacciones.Prestamo;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;
import com.grupo15.unab.servicios.ServiciosUsuarios;

import java.io.IOException;
import java.util.SortedMap;

/**
 * @author Grupo 15
 */
public class AplicacionLibreriaMain {

    public static void main(String[] args) throws IOException {

        Libro libroPrueba = new Libro("12777", "libro pal Danilo", "yo", "500", "400", "path");
        Usuario usuarioDocente3 = new Docente("9922222-8", "Docente", "Danilo", "f", "0", "magister");
//        Usuario usuarioDocente4 = new Docente("9922222-9", "Docente", "Cristhian", "f", "0", "magister");

//        ServiciosPrestamo.generaUnArriendo(usuarioDocente3.getRun(), libroPrueba.getISBN());

        Prestamo prestamo1 = ServiciosPrestamo.generaUnArriendo(usuarioDocente3.getRun(), libroPrueba.getISBN());

        ServiciosDevolucion.devolverLibro(prestamo1);

//        ServiciosPrestamo.generaUnArriendo(usuarioDocente3.getRun(), libroPrueba.getISBN());
//        ServiciosDevolucion.devolverLibro(prestamo1);

//        ServiciosDevolucion.devolverLibro(prestamo1);

//        Prestamo prestamo2 = ServiciosPrestamo.generaUnArriendo(usuarioDocente4.getRun(), libroPrueba.getISBN());
//
//        ServiciosPrestamo.generaUnArriendo(usuarioDocente3.getRun(), libroPrueba.getISBN());
//        ServiciosDevolucion.devolverLibro(prestamo2);


    }

}
