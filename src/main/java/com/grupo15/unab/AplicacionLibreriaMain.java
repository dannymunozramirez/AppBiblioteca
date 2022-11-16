package com.grupo15.unab;

import com.grupo15.unab.clientes.Clientes;
import com.grupo15.unab.data.LectorArchivosJSON;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;
import com.grupo15.unab.validaciones.Validaciones;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.*;

/**
 * @author Grupo 15
 */
public class AplicacionLibreriaMain {

    public static void main(String[] args) {


        // Lista de usuarios para pruebas - Esta lista debe venir de un archivo
//        List<Usuario> usuarios = new ArrayList<>(Arrays.asList(
//                new Docente("1-3","Test","M","magister"),
//                new Docente("1-9","Test","M","magister"),
//                new Docente("1-4","Test","M","magister"),
//                new Estudiante("1-2","Test Estudiante","M","Ingenieria" )
//        ));

        LectorArchivosJSON.lectorJSON("src/main/resources/usuarios.json");

        // Crear una lista de clientes con la lista previa
//        Clientes clientes = new Clientes(usuarios);

        // Imprime primera lista disponible en clientes
//        clientes.getUsuarios().forEach(usuario -> System.out.println(usuario.getRun()));

        // Agregando un cliente a la lista de clientes
//        clientes.agregarUsuario(new Estudiante("1-7","Test Estudiante","M","Ingenieria" ));

        // Imprime la lista con un cliente nuevo en caso que no exista en la primera lista
//        clientes.getUsuarios().forEach(usuario -> System.out.println(usuario.getRun()));

        LectorArchivosJSON lectorArchivosJSON = new LectorArchivosJSON();
        lectorArchivosJSON.toString();




    }
    static final String NOMBRE ="un valor";

//    public static ArrayList<Usuario>

    // File archivo

    // Se puede usar un JSON en vez de CVS ---> TRUE


    // TODO
    // Leer JSON - Escribir JSON



}
