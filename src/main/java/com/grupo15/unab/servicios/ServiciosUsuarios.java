package com.grupo15.unab.servicios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo15.unab.data.LectorArchivosJSON;
import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * <p>
 * Esta clase contiene todos los métodos estáticos para ser usados en
 * la aplicacion.
 * </p>
 *
 * @author grupo 15
 */
public final class ServiciosUsuarios {

    /**
     * <p>
     * Este método devuelve una lista de Usuarios obtenida desde un archivo JSON
     * </p>
     *
     * @param jsonObjectArray
     * @return
     */
    public static List<Usuario> creaListaDeUsuarios(JSONArray jsonObjectArray) {

        List<Usuario> usuariosDesdeJSON = new ArrayList<Usuario>();

        if (jsonObjectArray != null || !jsonObjectArray.isEmpty()) {
            jsonObjectArray.forEach(user -> {
                JSONObject jsonObject = (JSONObject) user;
                String tipo = (String) jsonObject.get("tipo");
                String run = (String) jsonObject.get("run");
                String nombre = (String) jsonObject.get("nombre");
                String genero = (String) jsonObject.get("genero");
                String prestamos = (String) jsonObject.get("prestamos");
                String grado = (String) jsonObject.get("grado");
                String carrera = (String) jsonObject.get("carrera");


                if (tipo.equals("Docente")) {
                    if (grado.equalsIgnoreCase("magister") || grado.equalsIgnoreCase("doctor")) {
                        Usuario usuarioDeJSONDocente = new Docente(run, tipo, nombre, genero, prestamos, grado);
                        usuariosDesdeJSON.add(usuarioDeJSONDocente);
                    }
                } else {
                    Usuario usuarioDeJSONEstudiante = new Estudiante(run, tipo, nombre, genero, prestamos, carrera);
                    usuariosDesdeJSON.add(usuarioDeJSONEstudiante);
                }
            });
        }
        return usuariosDesdeJSON;
    }


    public static List<Usuario> leeListaActualDesdeJSON() {
        List<Usuario> usuarios = creaListaDeUsuarios(LectorArchivosJSON.lectorJSON("src/main/resources/usuarios.json"))
                .isEmpty() ? new ArrayList<>()
                : creaListaDeUsuarios(LectorArchivosJSON.lectorJSON("src/main/resources/usuarios.json"));
        return usuarios;
    }

    public static void actualizaJSONUsuarios() throws IOException {
        /**
         * <p>
         *     Esta línea permite escribir el archivo JSON con la nueva version de la lista
         * </p>
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/main/resources/usuarios.json"), leeListaActualDesdeJSON());
    }

    /**
     * <p>
     * Este método retorna true en caso que un usuario se encunetre en la lista de usuarios
     * </p>
     *
     * @param usuario
     * @return
     */
    public static Boolean revisarRutUsuarioExiste(Usuario usuario) {

        leeListaActualDesdeJSON().forEach(usuario1 -> {
            if (usuario1.getRun().equals(usuario.getRun())) {
                return;
            }
            ;
        });
        return false;
    }


    /**
     * <p>
     * Este método retorna true si el run es un formato válido, es decir de mínimo 9 dígitos y máximo 10
     * con guión, código verificador y letra k
     * </p>
     *
     * @param cedula
     */
    public static Boolean verificarFormatoRun(String cedula) {
        if (cedula.length() >= 9 && cedula.length() <= 10 && cedula.charAt(cedula.length() - 2) == '-') {
            try {
                String digitK = String.valueOf(cedula.charAt(cedula.length() - 1));
                int digit = cedula.charAt(cedula.length() - 1);
                String s = digitK;
                if (digitK.equalsIgnoreCase("k")) {
                    return true;
                } else if (Integer.valueOf(s) >= 0 && Integer.valueOf(s) <= 9) {
                    return true;
                }
                return true;
            } catch (Exception e) {
//                System.exit(1);
                System.out.println("Excepcion al ingresar un run!!! " + e);
            }
        }
        return false;
    }

    public static Boolean verificaRunExiste(String run) {
        return leeListaActualDesdeJSON().stream().anyMatch(usuario -> usuario.getRun().equals(run));
    }

    /**
     * <p>
     * Este método verifica el género del usuario, retorna true si el género del usuario
     * corresponde a F o M
     * </p>
     *
     * @param genero
     * @return
     */
    public static Boolean verificarGenero(String genero) {

        if (genero.equalsIgnoreCase("F") || genero.equalsIgnoreCase("M")) {
            return true;
        }
        return false;
    }


    /**
     * <p>
     * Este método verifica el código ISBN, Si el ISBN es true el usuario no puede solicitar un libro, ya que
     * tiene un ISBN distinto de 0
     * </p>
     *
     * @param ISBN
     * @return
     */
    public static Boolean verificarISBN(Integer ISBN) {
        if (ISBN != 0) {
            return true;
        }
        return false;
    }


    /**
     * <p>
     * Verifica que el grado sea Doctor O Magister
     * </p>
     *
     * @param grado
     * @return
     */
    public static boolean veirifcarGradoDocente(String grado) {
        if (grado != null) {
            if (grado.equalsIgnoreCase("doctor") || grado.equalsIgnoreCase("magister")) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Este método agrega Usuario, valida que el usuario no exista para realizar la acción
     * </P>
     *
     * @param nuevoUsuario
     * @throws IOException
     */
    public static void escribirUsuarioJSON(Usuario nuevoUsuario) throws IOException {

        if (leeListaActualDesdeJSON().isEmpty()) {
            leeListaActualDesdeJSON().add(nuevoUsuario);
        } else {

            if (leeListaActualDesdeJSON().stream().anyMatch(usuario -> usuario.getRun().equalsIgnoreCase(nuevoUsuario.getRun()))) {
                System.out.println("EL USUARIO " + nuevoUsuario.getRun() + " YA EXISTE!!!");

            } else {
                // Agregando un usuario
                if (veirifcarGradoDocente(nuevoUsuario.getGrado())) {
                    leeListaActualDesdeJSON().add(nuevoUsuario);
                    System.out.println("USUARIO " + nuevoUsuario.getTipo() + " AGREGADO SATISFACTORIAMENTE BIENVENIDO!");

                } else if (nuevoUsuario.getCarrera() != null && !leeListaActualDesdeJSON().contains(nuevoUsuario)) {
                    leeListaActualDesdeJSON().add(nuevoUsuario);
                    System.out.println("EL USUARIO FUE AGREGADO A LA LISTA DE USUARIOS, ES " + nuevoUsuario.getTipo() + " BIENVENIDO!");

                }
            }

        }
        actualizaJSONUsuarios();
    }

    /**
     * <p>
     * Este método actualiza un usuario de la lista obtenida desde el archivo JSON
     * </p>
     *
     * @param nuevoUsuario
     * @throws IOException
     */
    public static void actualizarUsuario(Usuario nuevoUsuario) throws IOException {

        for (Usuario usuarioEvaluado : leeListaActualDesdeJSON()) {
            if (usuarioEvaluado.getRun().equalsIgnoreCase(nuevoUsuario.getRun())) {

                // Llamar el metodo validar grado academico TRUE/FALSE
                if (veirifcarGradoDocente(nuevoUsuario.getGrado())) {
                    // usar un metodo porque no esta copiando el object entero
                    leeListaActualDesdeJSON().set(leeListaActualDesdeJSON().indexOf(usuarioEvaluado)+1, nuevoUsuario);
                    System.out.println("USUARIO " + usuarioEvaluado.getRun() + " ACTUALIZADO SATISFACTORIAMENTE");
                    break;
                } else if (!nuevoUsuario.getCarrera().isEmpty()) {
                    leeListaActualDesdeJSON().set(leeListaActualDesdeJSON().indexOf(usuarioEvaluado)+1, nuevoUsuario);
                    System.out.println("USUARIO " + usuarioEvaluado.getRun() + " ACTUALIZADO SATISFACTORIAMENTE");
                    break;
                }
                break;
            }
        }
        actualizaJSONUsuarios();
    }


    /**
     * <p>
     * Este método permite borrar un Usuario del archivo JSON.
     * El parámetro permite evaluar si el usuario está presente en la
     * lista leída desde el archivo JSON
     * </p>
     *
     * @param nuevoUsuario
     * @throws IOException
     */
    public static void borrarUsuarioJSON(Usuario nuevoUsuario) throws IOException {

        Boolean flag = true;

        List<Usuario> usuarios = creaListaDeUsuarios(LectorArchivosJSON.lectorJSON("src/main/resources/usuarios.json"))
                .isEmpty() ?
                new ArrayList<>()
                : creaListaDeUsuarios(LectorArchivosJSON.lectorJSON("src/main/resources/usuarios.json"));

        for (Usuario usuarioEvaluado : usuarios) {

            if (usuarioEvaluado.getRun().equalsIgnoreCase(nuevoUsuario.getRun())) {
                usuarios.remove(usuarios.indexOf(usuarioEvaluado));
                System.out.println("USUARIO " + usuarioEvaluado.getRun() + " ELIMINADO SATISFACTORIAMENTE");
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("USUARIO NO EXISTE PARA SER ELIMINADO");
        }

        /**
         * <p>
         *     mapper.writeValue(new File("src/main/resources/usuarios.json"), usuarios);
         *     Esta línea permite escribir el archivo JSON con la nueva version de la lista
         * </p>
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/main/resources/usuarios.json"), usuarios);

    }

    public static Usuario buscaUsuario(String run) {

        for (Usuario usuario : leeListaActualDesdeJSON()) {
            System.out.println(usuario.getRun() + " Lista actual");
        }

        for (Usuario usuario : leeListaActualDesdeJSON()) {
            System.out.println(usuario.getRun() + " Lista actual dentro del for");

            System.out.println(usuario.getRun().equalsIgnoreCase(run) && verificarFormatoRun(run));
            if (usuario.getRun().equalsIgnoreCase(run) && verificarFormatoRun(run)) {
                System.out.println("Retornando usuario " + usuario);
                System.out.println(usuario.getPrestamos());
                return usuario;
            }
        }
        throw new NoSuchElementException("Usuario no encontrado " + run);
    }

}
