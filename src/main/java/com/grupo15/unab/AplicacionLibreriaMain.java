package com.grupo15.unab;

import com.grupo15.unab.clientes.UsuariosJSON;
import com.grupo15.unab.data.LectorArchivosJSON;
import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;
import com.grupo15.unab.servicios.Servicios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Usuario usuarioDocente2 = new Docente("22222-8", "Docente", "Docente Prueba III", "f", 0, "magister");


        Servicios.escribirUsuarioJSON(usuarioDocente2);
        Servicios.escribirUsuarioJSON(usuarioEstudiante);

        Libro arteEnJava = new Libro(131, "Arte en Java", "Codd", 5, 5);
        Libro programacionEnJava = new Libro(386, "Programacion en Java", "Luis Joyanes", 2, 2);
        Map<Libro, Integer> mapLibros = new HashMap<>();
        mapLibros.put(arteEnJava, 50);
        mapLibros.put(programacionEnJava, 50);

    }

}
