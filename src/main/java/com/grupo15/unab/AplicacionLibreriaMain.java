package com.grupo15.unab;

import com.grupo15.unab.clientes.Clientes;
import com.grupo15.unab.data.LectorArchivosJSON;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;
import com.grupo15.unab.validaciones.Servicios;

import java.util.List;

/**
 * @author Grupo 15
 */
public class AplicacionLibreriaMain {

    public static void main(String[] args) {

        /**
         * Creando lista de usuarios con el método estático Servicios.creaListaDeUsuarios
         */
        List<Usuario> usuarios = Servicios.creaListaDeUsuarios(LectorArchivosJSON.lectorJSON("src/main/resources/usuarios.json"));

        // TODO
        /**
         * <P>
         *     Desarrollar la lógica para impedir que un usuario repetido desde
         *     JSON file sea agregado a la lista de clientes
         * </P>
         */

        /**
         * La lista que se esta pasando como parametro es obtenida desde la clase LectorArchivosJSON
         * EVALUA LA LISTA INGRESADA (primera lextura), retorna true si hay repetidos de lo contrario retorna false
         */
        Servicios.revisarRut(usuarios);
        System.out.println("EXISTEN USUARIOS REPETIDOS? " + Servicios.revisarRut(usuarios));

        /**
         * Creando una instancia Clientes donde será almacenada la lista
         */
        Clientes clientes = new Clientes(usuarios);

        /**
         * <p>
         *     Agregando un nuevo cliente
         * </p>
         */
        clientes.agregarUsuario(new Estudiante("1-9", "Test Estudiante", "M", "Ingenieria"));

        /**
         * <p>
         *     Nuevo usuario agregado satisfactoriamente
         * </p>
         */
        clientes.getUsuarios().forEach(usuario -> {
            System.out.println(usuario.getRun());
        });

    }
    // TODO
    // Leer JSON - Escribir JSON
}
