package com.grupo15.unab.servicios;

import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * Esta clase contiene todos los metodos estaticos para ser usados en
 * la aplicacion.
 * </p>
 *
 * @author grupo 15
 */
public final class Servicios {

    /**
     * <p>
     * Este método verifica que los rut ingresados no esten repetidos
     * </p>
     *
     * @param usuarios
     * @return Boolean
     */
    static public Boolean revisarRut(List<Usuario> usuarios) {
        /**
         * <p>
         *     Primero hacemos una lista de rutUsuarios
         * </p>
         */
        List<String> rutUsuarios = usuarios.stream().map(Usuario::getRun).collect(Collectors.toList());

        /**
         * <p>
         *     Comparando la cantidad de elementos únicos porporcionados por
         *     stream().distinct().count() con la cantidad de elementos
         *     en la lista rutUsuarios. Si hay elementos repetidos la cantidad de
         *     elementos unicos sera menor a la cantidad de elementos originales de
         *     la lista de rutUsuarios
         * </p>
         *
         */
        return rutUsuarios.stream().distinct().count() != rutUsuarios.size();
    }

    public static Boolean revisarRutUsuarioExiste(Usuario usuario, List<Usuario> usuarios) {

        // Revisa los elementos de la lista y retorna true si hay un rut existe en la lista
        if (usuario != null) {
            return usuarios.stream().anyMatch(usuario1 -> usuario1.getRun().equals(usuario.getRun()));
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

        jsonObjectArray.forEach(user -> {
            JSONObject jsonObject = (JSONObject) user;
            String tipo = (String) jsonObject.get("tipo");
            String run = (String) jsonObject.get("run");
            String nombre = (String) jsonObject.get("nombre");
            String genero = (String) jsonObject.get("genero");
            String ISBN = (String) jsonObject.get("ISBN");
            String grado = (String) jsonObject.get("grado");
            String carrera = (String) jsonObject.get("carrera");

            if (tipo.equals("Docente")) {
                Usuario usuarioDeJSON = new Docente(run, nombre, genero, grado);
                usuariosDesdeJSON.add(usuarioDeJSON);
                System.out.println("USUARIO DOCENTE AGREGADO " + usuarioDeJSON.getRun());
            } else {
                // TODO
                // revisar carrera o grado???
                Usuario usuarioDeJSON = new Estudiante(run, nombre, genero, grado);
                usuariosDesdeJSON.add(usuarioDeJSON);
                System.out.println("USUARIO ESTUDIANTE AGREGADO " + usuarioDeJSON.getRun());
            }
        });
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
     * @param genero
     * @return
     */
    public static Boolean verificarGenero(String genero) {

        if (genero.equalsIgnoreCase("F") || genero.equalsIgnoreCase("M")) {
            System.out.println(" GENERO VALIDADO!!!!");
            return true;
        }
        return false;
    }

    /**
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
     *
     * </p>
     * @param usuario
     * @param usuarios
     */
    public static void eliminarUsuario(Usuario usuario, List<Usuario> usuarios) {
        // TODO
        // Escribir en JSON para eliminar de la lista
        for (Usuario usuario1 : usuarios) {

            if (usuarios != null) {
                if(usuarios.contains(usuario)){
                    if (usuario1.getRun().equals(usuario.getRun())) {
                        usuarios.remove(usuario1);
                        System.out.println("USUARIO ELIMINADO");
                        break;
                    }
                }else {
                    System.out.println("USUARIO NO EXISTE");
                    break;
                }
            }
        }
    }


}
