package com.grupo15.unab.validaciones;

import com.grupo15.unab.usuarios.Usuario;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * Esta clase contiene todos los metodos estaticos para ser usados en
 * la aplicacion. La declaración de "final" nos permite evitar que
 * esta clase sea sobrescrita, instanciada o heredada.
 * </p>
 *
 * @author grupo 15
 */
public final class Validaciones {

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

}
