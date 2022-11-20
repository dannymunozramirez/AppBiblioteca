package com.grupo15.unab.servicios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo15.unab.data.LectorArchivosJSON;
import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <p>
 * Esta clase contiene todos los métodos estáticos para ser usados con la Clase Libro
 * </p>
 *
 * @author grupo 15
 */
public final class ServiciosLibro {

    /**
     * <p>
     * Este método devuelve una lista de Libros obtenida desde un archivo JSON
     * I
     * </p>
     *
     * @param jsonObjectArray
     * @return
     */
    public static List<Libro> creaListaLibros(JSONArray jsonObjectArray) {

        List<Libro> librosEnJson = new ArrayList<Libro>();

        if (jsonObjectArray != null || !jsonObjectArray.isEmpty()) {
            jsonObjectArray.forEach(libro -> {
                JSONObject jsonObject = (JSONObject) libro;

                String titulo = (String) jsonObject.get("titulo");
                String autor = (String) jsonObject.get("autor");
                String cantidadEnBiblioteca = (String) jsonObject.get("cantidadEnBiblioteca");
                String disponiblePrestamos = (String) jsonObject.get("cantidadDisponiblePrestamo");
                String imagen = (String) jsonObject.get("imagen");
                String ISBN = (String) jsonObject.get("isbn");

                System.out.println(ISBN + " ISBN");

                if (ISBN != null) {
                    Libro libroDeJSONDocente = new Libro(ISBN, titulo, autor, cantidadEnBiblioteca, disponiblePrestamos, imagen);
                    librosEnJson.add(libroDeJSONDocente);
                }
            });
        }
        return librosEnJson;
    }

    /**
     * <p>
     * Verifica ISBN repetidos
     * II
     * </P>
     *
     * @throws IOException
     */
    public static Boolean verificaISBN(Libro libroEvaluado) {
        List<Libro> libros = creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"))
                .isEmpty() ? new ArrayList<>()
                : creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"));


        // Verifica ISBN
        if (libros.stream().anyMatch(libro -> libro.getISBN().equalsIgnoreCase(libroEvaluado.getISBN()))) {
            System.out.println("EL LIBRO " + libroEvaluado.getISBN() +
                    " YA EXISTE, NO ES ÚNICO");
            return true;
        }

        return false;
    }

    public static void escribirLibroJSON(Libro nuevoLibro) throws IOException {

        List<Libro> libros = creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"))
                .isEmpty() ? new ArrayList<>()
                : creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"));

        System.out.println(nuevoLibro.getISBN());

        System.out.println(libros.size() + " 88888888888");;
        libros.forEach(libro -> {
            System.out.println(libro.getISBN() + " @@@@@@@@@@@");
        });
        try {

            if (libros.isEmpty()) {
                System.out.println("DENTRO DEL METODO +++++++++++++");
                libros.add(nuevoLibro);
            } else {
                // Agrega el libro si no existe en la lista
                System.out.println(verificaISBN(nuevoLibro));
                if (!verificaISBN(nuevoLibro)) {
                    libros.add(nuevoLibro);
                }
            }


            System.out.println(libros.size());
            System.out.println(nuevoLibro.getISBN());

            /**
             * <p>
             *     Esta línea permite escribir el archivo JSON con la nueva version de la lista
             * </p>
             */
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("src/main/resources/libros.json"), libros);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * Verifica la cantidad de libros en biblioteca, retorna true si la cantidad es igual a cero e indica que
     * un libro especifico no tiene stock disponible, de lo contrario retorna false
     * </p>
     *
     * @param libroEvaluado
     * @return
     */
    public static Boolean verificaCantidadEnBiblioteca(Libro libroEvaluado) {

        List<Libro> libros = creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"))
                .isEmpty() ? new ArrayList<>()
                : creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"));


        // VERIFICA CANTIDAD EN BIBLIOTECA
        if (libros.stream().anyMatch(libro -> libro.getCantidadEnBiblioteca().equalsIgnoreCase("0"))) {
            System.out.println("EL LIBRO " + libroEvaluado.getISBN() +
                    " NO TIENE STOCK EN LA BIBLIOTECA, DEBE SER MAYOR A CERO");
            return true;
        }

        return false;
    }

    /**
     * <p>
     * Valida que la cantidad ingresada de Cantidad Disponible Prestamo no sea igual a cero
     * o mayor a los disponibles en biblioteca
     * </p>
     *
     * @param libroEvaluado
     * @return
     */
    public static Boolean verificaCantidadEnDisponible(Libro libroEvaluado) {

        List<Libro> libros = creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"))
                .isEmpty() ? new ArrayList<>()
                : creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"));


        // VERIFICA CANTIDAD EN BIBLIOTECA
        if (libros.stream().anyMatch(libro -> (libro.getCantidadDisponiblePrestamo().equalsIgnoreCase("0")
                || Integer.valueOf(libro.getCantidadEnBiblioteca()) <= Integer.valueOf(libroEvaluado.getCantidadEnBiblioteca())))) {
            System.out.println("EL VALOR INGRESADO NO ES VÁLIDO");
            return true;
        }

        return false;
    }


    /**
     * <p>
     * Este método permite borrar un Libro del archivo JSON.
     * El parámetro permite evaluar si el usuario está presente en la
     * lista leída desde el archivo JSON
     * </p>
     *
     * @param libroIngresado
     * @throws IOException
     */
    public static void borrarLibroJSON(Libro libroIngresado) throws IOException {

        List<Libro> libros = creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"))
                .isEmpty() ? new ArrayList<>()
                : creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"));


        Boolean flag = true;

        for (Libro libroEvaluado : libros) {

            if (libros.stream().anyMatch(libro -> libro.getISBN().equalsIgnoreCase(libroIngresado.getISBN()))) {
                libros.remove(libros.indexOf(libroEvaluado));
                System.out.println("LIBRO " + libroIngresado.getISBN() + " ELIMINADO SATISFACTORIAMENTE");
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("LIBRO NO EXISTE PARA SER ELIMINADO");
        }

        /**
         * <p>
         *     mapper.writeValue(new File("src/main/resources/libros.json"), usuarios);
         *     Esta línea permite escribir el archivo JSON con la nueva version de la lista
         * </p>
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/main/resources/libros.json"), libros);

    }
}
