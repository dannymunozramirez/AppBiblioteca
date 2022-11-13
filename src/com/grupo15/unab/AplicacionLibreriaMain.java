package com.grupo15.unab;

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

        List<Usuario> usuarios = new ArrayList<>(Arrays.asList(
                new Docente("1-3","Test","M","magister"),
                new Docente("1-3","Test","M","magister"),
                new Docente("1-4","Test","M","magister"),
                new Estudiante("1-2","Test Estudiante","M","Ingenieria" )
        ));

        // agregar un usuario a una lista, donde???

        System.out.println(Validaciones.revisarRut(usuarios));
        System.out.println(usuarios);


    }


}
