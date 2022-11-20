package com.grupo15.unab;

import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.servicios.ServiciosLibro;
import com.grupo15.unab.servicios.ServiciosPrestamo;
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

        // Usuarios para poblar el JSON file
//        Usuario usuarioEstudiante = new Estudiante("123456-8", "Estudiante", "ESTUDIANTE ***", "f", 0, "Ingenieria");
//        Usuario usuarioDocente1 = new Docente("22222-1", "Docente", "!!!!!!I", "f", 0, "magister");
//        Usuario usuarioDocente2 = new Docente("22222-2", "Docente", "medio", "f", 0, "magister");
        Usuario usuarioDocente3 = new Docente("9922222-8", "Docente", " VARIAS veces", "f", "0", "magister");
//        Usuario usuarioDocente4 = new Docente("22222-9", "Docente", " tres veces", "f", 0, "magister");
//        Usuario usuarioDocente5 = new Docente("99999-9", "Docente", " tres veces", "f", 0, "magister");


        // Agregando usuarios
//        ServiciosUsuarios.escribirUsuarioJSON(usuarioDocente5);
//        ServiciosUsuarios.escribirUsuarioJSON(usuarioDocente1);
//        ServiciosUsuarios.escribirUsuarioJSON(usuarioDocente2);
//        ServiciosUsuarios.escribirUsuarioJSON(usuarioDocente3);

        ServiciosUsuarios.escribirUsuarioJSON(usuarioDocente3);
        System.out.println("Lo escribe");
//        // Actualizando usuarios
//        ServiciosUsuarios.actualizarUsuario(usuarioDocente3);

        // Borrando usuario
//        ServiciosUsuarios.borrarUsuarioJSON(usuarioDocente2);
        Libro libroPrueba = new Libro("12777", "libro", "yo", "500", "400", "path");
        Libro libroPrueba2 = new Libro("12333", "libro nuevo", "yo", "500", "300", "path");

//        ServiciosLibro.escribirLibroJSON(libroPrueba2);
        ServiciosLibro.escribirLibroJSON(libroPrueba);
//        ServiciosLibro.escribirLibroJSON(libroPrueba2);
//        ServiciosLibro.verificaCantidadEnDisponible(libroPrueba);

//        Libro libro = ServiciosLibro.buscaLibro("12333");
//        System.out.println(libroPrueba.getISBN() + " Libro encontrado");

        ServiciosPrestamo.generaUnArriendo(usuarioDocente3.getRun(), libroPrueba.getISBN());

        ServiciosUsuarios.leeListaActualDesdeJSON().forEach(usuario -> {
            System.out.println(usuario.getPrestamos());
        });

        ServiciosLibro.leeListaActualDesdeJSON().forEach(libro -> {
            System.out.println(libro.getCantidadDisponiblePrestamo());
        });



    }

}
