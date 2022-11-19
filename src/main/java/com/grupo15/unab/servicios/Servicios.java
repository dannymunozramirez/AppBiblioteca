package com.grupo15.unab.servicios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo15.unab.data.LectorArchivosJSON;
import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;

import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * Esta clase contiene todos los métodos estáticos para ser usados en
 * la aplicacion.
 * </p>
 *
 * @author grupo 15
 */
public final class Servicios {

    /**
     * <p>
     * Este método retorna true en caso que un usuario se encunetre en la lista de usuarios
     * </p>
     *
     * @param usuario
     * @param usuarios
     * @return
     */
    public static Boolean revisarRutUsuarioExiste(Usuario usuario, List<Usuario> usuarios) {

        if (usuario != null) {
            return usuarios.contains(usuario);
        }
        return false;
    }

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
                Integer ISBN = (Integer) jsonObject.get("ISBN");
                String grado = (String) jsonObject.get("grado");
                String carrera = (String) jsonObject.get("carrera");

                if (tipo.equals("Docente")) {
                    if (grado.equalsIgnoreCase("magister") || grado.equalsIgnoreCase("doctor")) {
                        Usuario usuarioDeJSONDocente = new Docente(run, tipo, nombre, genero, ISBN, grado);
                        usuariosDesdeJSON.add(usuarioDeJSONDocente);
                    }
                } else {
                    Usuario usuarioDeJSONEstudiante = new Estudiante(run, tipo, nombre, genero, ISBN, carrera);
                    usuariosDesdeJSON.add(usuarioDeJSONEstudiante);
                }
            });
        }
        return usuariosDesdeJSON;
    }

    /**
     * <p>
     * Este método retorna true si el run es un formato válido, es decir de mínimo 9 dígitos y máximo 10
     * con guión, código verificador y letra k
     * </p>
     *
     * @param cedula
     */
    public static Boolean verificarRun(String cedula) {
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

    // TODO
    /*
    Map<Libro, Integer> libro
    libro.forEach((key, value) -> {
            System.out.println(key.getNombre() + " ----  " + (value -1) + " UNIDADES");

        });

    * */

    /**
     * <p>
     *
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
     * Este método recibe una lista de usuarios (Existentes) y un Usuario (Nuevo o Existente)
     * lo agrega en caso que no exista y lo actualiza en caso contrario.
     * </P>
     *
     * @param nuevoUsuario
     * @throws IOException
     */
    public static void escribirUsuarioJSON(Usuario nuevoUsuario) throws IOException {

        /**
         * <p>
         *  Crea y pobla una lista. Si la lista esta vacía crea una nueva lista de lo contrario le asigna los
         *  valores existentes en json a la lista
         * </p>
         */
        List<Usuario> usuarios = creaListaDeUsuarios(LectorArchivosJSON.lectorJSON("src/main/resources/usuarios.json"))
                .isEmpty() ? new ArrayList<>()
                : creaListaDeUsuarios(LectorArchivosJSON.lectorJSON("src/main/resources/usuarios.json"));

        System.out.println("Primer loop");
        usuarios.forEach(usuario -> {
            System.out.println(usuario.getRun());
        });

        try {
            if (usuarios.isEmpty()) {
                usuarios.add(nuevoUsuario);
                System.out.println("Primer usuario agregado");
            } else {

                if (usuarios.stream().anyMatch(usuario -> usuario.getRun().equalsIgnoreCase(nuevoUsuario.getRun()))) {
                    System.out.println("EL USUARIO YA EXISTE!!!");

                } else {
                    // Agregando un usuario
                    if (veirifcarGradoDocente(nuevoUsuario.getGrado())) {
                        usuarios.add(nuevoUsuario);
                        System.out.println("EL USUARIO FUE AGREGADO A LA LISTA DE USUARIOS, ES " + nuevoUsuario.getTipo() + " BIENVENIDO!");

                    } else if (nuevoUsuario.getCarrera() != null && !usuarios.contains(nuevoUsuario)) {
                        usuarios.add(nuevoUsuario);
                        System.out.println("EL USUARIO FUE AGREGADO A LA LISTA DE USUARIOS, ES " + nuevoUsuario.getTipo() + " BIENVENIDO!");

                    }
                }


            }


            /**
             * <p>
             *     mapper.writeValue(new File("src/main/resources/usuarios.json"), usuarios);
             *     Esta línea permite escribir el archivo JSON con la nueva version de la lista
             * </p>
             */
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("src/main/resources/usuarios.json"), usuarios);

            System.out.println("Lista al final: ");
            usuarios.forEach(usuario -> {
                System.out.println(usuario.getRun());
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarUsuario(Usuario nuevoUsuario) throws IOException {

        List<Usuario> usuarios = creaListaDeUsuarios(LectorArchivosJSON.lectorJSON("src/main/resources/usuarios.json"))
                .isEmpty() ?
                new ArrayList<>()
                : creaListaDeUsuarios(LectorArchivosJSON.lectorJSON("src/main/resources/usuarios.json"));

        for (Usuario usuarioEvaluado : usuarios) {
            if (usuarioEvaluado.getRun().equalsIgnoreCase(nuevoUsuario.getRun())) {

                // Llamar el metodo validar grado academico TRUE/FALSE
                if (veirifcarGradoDocente(nuevoUsuario.getGrado())) {
                    // usar un metodo porque no esta copiando el object entero
                    usuarios.set(usuarios.indexOf(usuarioEvaluado), nuevoUsuario);
                    break;
                } else if (!nuevoUsuario.getCarrera().isEmpty()) {
                    usuarios.set(usuarios.indexOf(usuarioEvaluado), nuevoUsuario);
                    break;
                }
                break;
            }
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


    /**
     * <p>
     * Este método permite borrar un Usuario del archivo JSON y actualiza la lista de Ususarios
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
//                usuarios.remove(usuarios.size() - 1);
                ;
                usuarios.remove(usuarios.indexOf(usuarioEvaluado));
                System.out.println("USUARIO " + usuarioEvaluado.getRun() + " ELIMINADO SATISFACTORIAMENTE");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("USUARIO NO EXISTE PARA SER ELIMINADO");
        }

        usuarios.forEach(usuario -> {
            System.out.println(usuario.getRun() + " LISTA DE USUARIOS --------");
        });

        /**
         * <p>
         *     mapper.writeValue(new File("src/main/resources/usuarios.json"), usuarios);
         *     Esta línea permite escribir el archivo JSON con la nueva version de la lista
         * </p>
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/main/resources/usuarios.json"), usuarios);


    }
}
