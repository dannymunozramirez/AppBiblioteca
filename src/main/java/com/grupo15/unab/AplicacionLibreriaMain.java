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

        // Usuarios para poblar el JSON file
        Usuario usuarioEstudiante = new Estudiante("123456-8", "Estudiante", "ESTUDIANTE ***", "f", 0, "Ingenieria");
        Usuario usuarioDocente1 = new Docente("22222-1", "Docente", "!!!!!!I", "f", 0, "magister");
        Usuario usuarioDocente2 = new Docente("22222-2", "Docente", "Docente II y medio", "f", 0, "magister");
        Usuario usuarioDocente3 = new Docente("22222-8", "Docente", " VARIAS veces", "f", 0, "magister");
        Usuario usuarioDocente4 = new Docente("22222-9", "Docente", " tres veces", "f", 0, "magister");

        // Agregando usuarios
        Servicios.escribirUsuarioJSON(usuarioDocente1);
        Servicios.escribirUsuarioJSON(usuarioDocente2);
        Servicios.escribirUsuarioJSON(usuarioDocente3);
        Servicios.escribirUsuarioJSON(usuarioDocente4);

        // Actualizando usuarios
        Servicios.actualizarUsuario(usuarioDocente3);

        // Borrando usuario
        Servicios.borrarUsuarioJSON(usuarioDocente2);

    }

}
