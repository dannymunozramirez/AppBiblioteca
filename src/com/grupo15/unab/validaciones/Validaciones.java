package com.grupo15.unab.validaciones;

import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.usuarios.Usuario;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author grupo 15
 */
public class Validaciones {

    /**
     * <p>
     * Este metodo verifica que los rut ingresados no esten repetido
     * </p>
     *
     * @param usuarios
     * @return Boolean
     */
    public static Boolean revisarRut(List<Usuario> usuarios) {
        /**
         * <p>
         *     Haciendo una lista de rutUsuarios para verificar que no esten repetidos
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

    public static Boolean revisarLibro(List<Libro> usuarios) {
        /**
         * <p>
         *     Haciendo una lista de rutUsuarios para verificar que no esten repetidos
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

}