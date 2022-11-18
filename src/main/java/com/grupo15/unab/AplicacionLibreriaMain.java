package com.grupo15.unab;

import com.grupo15.unab.clientes.UsuariosJSON;
import com.grupo15.unab.data.LectorArchivosJSON;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;
import com.grupo15.unab.servicios.Servicios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grupo 15
 */
public class AplicacionLibreriaMain {

    public static void main(String[] args) throws IOException {

        /**
         * Creando lista de usuarios con el método estático Servicios.creaListaDeUsuarios
         */
        // Crea el primer usuario
        Usuario usuarioEstudiante = new Estudiante("123456-8", "Estudiante", "Docente Prueba", "f", 0, "Ingenieria");

        // Crea una lista de usuarios con el primer usuario
        Servicios.escribirUsuarioJSON(new ArrayList<>(), usuarioEstudiante);

        // Creando la lista con los nuevo valores del JSON
        List<Usuario> usuarios = Servicios.creaListaDeUsuarios(LectorArchivosJSON.lectorJSON("src/main/resources/usuarios.json"));

        Usuario usuarioDocente2 = new Docente("987653-8", "Docente", "Docente Prueba", "f", 0, "Ingenieria");

        Usuario usuarioDocente3 = new Docente("999993-8", "Docente", "Docente III", "f", 0, "Ingenieria");

        // Pasarle la lista con el nuevo usuario
        Servicios.escribirUsuarioJSON(usuarios, usuarioDocente2);

        // Pasarle la lista con el nuevo usuario
        Servicios.escribirUsuarioJSON(usuarios, usuarioDocente3);

        System.out.println(" =============== ");
        usuarios.forEach(usuario -> {
            System.out.println(usuario.getRun());
        });
        System.out.println(" =============== ");
        Usuario usuarioDocente4 = new Docente("999993-9", "Docente", "Docente III", "f", 0, "Ingenieria");

        Servicios.borrarUsuarioJSON(usuarios, usuarioDocente2);

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
//        Servicios.revisarRut(usuarios);
//        System.out.println("EXISTEN USUARIOS REPETIDOS? " + Servicios.revisarRut(usuarios));

        /**
         * Creando una instancia UsuariosJSON donde será almacenada la lista o un nuevo Usuario
         */
//        UsuariosJSON usuariosJSON = new UsuariosJSON(usuarios);

        /**
         * <p>
         *     Agregando un nuevo cliente
         * </p>
         */
//        usuariosJSON.agregarUsuario(usuarioEstudiante);
//        Usuario usuarioEstudiante2 = new Estudiante("8765433-8","Estudiante","Estudiante Prueba II","f", 1,"Ingenieria");
//        usuariosJSON.agregarUsuario(usuarioEstudiante2);

//        List<Usuario> usuarios1 = usuariosJSON.getUsuarios();


//        Servicios.eliminarUsuario(usuarioEstudiante,usuarios1);


    }
    // TODO
    /**
     *  Escribir JSON
     */


}
