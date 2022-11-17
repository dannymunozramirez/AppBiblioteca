package com.grupo15.unab;

import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.transacciones.Prestamo;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;
import com.grupo15.unab.validaciones.Validaciones;

import java.util.*;

/**
 * @author Grupo 15
 */
public class AplicacionLibreriaMain {

    public static void main(String[] args) {

        Usuario usuario = new Docente("1-2","Test","M","magister");

        List<Usuario> usuarios = new ArrayList<>(Arrays.asList(
                new Docente("1-3","Test","M","magister"),
                new Docente("1-3","Test","M","magister"),
                new Docente("1-4","Test","M","magister"),
                new Estudiante("1-2","Test Estudiante","M","Ingenieria" )
        ));
        List<Libro> libros = new ArrayList<>(Arrays.asList(
                new Libro(131,"Arte en Java","Codd",5,5),
                new Libro(386, "Programacion en Java","Luis Joyanes",2,2),
                new Libro(486, "Calculo Diferencial", "Granvile",2,2),
                new Libro(001, "El Principito", "Anonimo",1,1),
                new Libro(100, "Modelo de Datos","Fco Ruiz", 4,3)
        );



        System.out.println(Validaciones.revisarRut(usuarios));
        System.out.println(usuarios);


    }


}
