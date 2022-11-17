package com.grupo15.unab;

import com.grupo15.unab.clientes.UsuariosJSON;
import com.grupo15.unab.data.LectorArchivosJSON;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;
import com.grupo15.unab.servicios.Servicios;

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
        UsuariosJSON usuariosJSON = new UsuariosJSON(usuarios);

        Usuario usuarioEstudiante = new Estudiante("199999-4", "Test Estudiante", "f", "Ingenieria");
        /**
         * <p>
         *     Agregando un nuevo cliente
         * </p>
         */
        usuariosJSON.agregarUsuario(usuarioEstudiante);
        Usuario usuarioEstudiante2 = new Estudiante("199333-4", "Test Estudiante", "f", "Ingenieria");
        List<Usuario> usuarios1 = usuariosJSON.getUsuarios();

        /**
         * <p>
         *     Nuevo usuario agregado satisfactoriamente
         * </p>
         */
        usuariosJSON.getUsuarios().forEach(usuario -> {
//            Servicios.verificarRun(usuario.getRun());
//            System.out.println(Servicios.verificarRun(usuario.getRun()));
//            System.out.println(usuario.getRun());
//            Servicios.verificarGenero(usuario.getGenero());
//            System.out.println(Servicios.verificarGenero(usuario.getGenero()));

        });

        Servicios.eliminarUsuario(usuarioEstudiante,usuarios1);

        usuariosJSON.getUsuarios().forEach(usuario -> {
            System.out.println(usuario.getRun());
        });

    }
    // TODO
    /**
     *  Escribir JSON
     */





}
