package com.grupo15.unab;

import com.grupo15.unab.clientes.Clientes;
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

        // Lista de usuarios para pruebas
        List<Usuario> usuarios = new ArrayList<>(Arrays.asList(
                new Docente("1-3","Test","M","magister"),
                new Docente("1-9","Test","M","magister"),
                new Docente("1-4","Test","M","magister"),
                new Estudiante("1-2","Test Estudiante","M","Ingenieria" )
        ));

        // Crear una lista de clientes con la lista previa
        Clientes clientes = new Clientes(usuarios);

        // Imprime primera lista disponible en clientes
        clientes.getUsuarios().forEach(usuario -> System.out.println(usuario.getRun()));

        // Agregando un cliente a la lista de clientes
        clientes.agregarUsuario(new Estudiante("1-7","Test Estudiante","M","Ingenieria" ));

        // Imprime la lista con un cliente nuevo en caso que no exista en la primera lista
        clientes.getUsuarios().forEach(usuario -> System.out.println(usuario.getRun()));

    }


}
