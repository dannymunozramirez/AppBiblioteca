package com.grupo15.unab.servicios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo15.unab.data.LectorArchivosJSON;
import com.grupo15.unab.libros.Libro;

import com.grupo15.unab.usuarios.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


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
     * Podria estar en LectorArchivosJSON clase ----- ?????
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
     * Este método entrega el estado actual de la lista en el archivo JSON
     * </p>
     *
     * @return
     */
    public static List<Libro> leeListaActualDesdeJSON() {
        List<Libro> libros = creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"))
                .isEmpty() ? new ArrayList<>()
                : creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"));
        return libros;
    }

    /**
     * <p>
     *
     * </p>
     *
     * @throws IOException
     */
    public static void actualizaJSON() throws IOException {
        /**
         * <p>
         *     Esta línea permite escribir el archivo JSON con la nueva version de la lista
         * </p>
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/main/resources/libros.json"), leeListaActualDesdeJSON());
    }

    public static void actualizarLibro(Libro libro) throws IOException {

        for (Libro libroEvaluado : leeListaActualDesdeJSON()) {
            if (libroEvaluado.getISBN().equalsIgnoreCase(libro.getISBN())) {
                leeListaActualDesdeJSON().set(leeListaActualDesdeJSON().indexOf(libroEvaluado), libro);
                System.out.println("LIBRO " + libroEvaluado.getISBN() + " ACTUALIZADO SATISFACTORIAMENTE");
                break;

            }
        }
    }

    /**
     * <p>
     * Verifica ISBN repetidos
     * II
     * </P>
     *
     * @throws IOException
     */
    public static Boolean verificaISBN(String isbn) {

        if (leeListaActualDesdeJSON().stream().anyMatch(libro -> libro.getISBN().equalsIgnoreCase(isbn))) {
            System.out.println("EL LIBRO " + isbn +
                    " YA EXISTE, NO ES ÚNICO");
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Este método escribe y actualiza un libro en el archivo JSON
     * </p>
     *
     * @param nuevoLibro
     * @throws IOException
     */
    public static void escribirLibroJSON(Libro nuevoLibro) throws IOException {

        if (leeListaActualDesdeJSON().isEmpty()) {
            if (verificaCantidadEnDisponible(nuevoLibro)) {
                leeListaActualDesdeJSON().add(nuevoLibro);
            }
        } else {
            System.out.println(verificaISBN(nuevoLibro.getISBN()));
            if (!verificaISBN(nuevoLibro.getISBN())) {
                leeListaActualDesdeJSON().add(nuevoLibro);
            }
        }
        actualizaJSON();
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

        // VERIFICA CANTIDAD EN BIBLIOTECA
        if (leeListaActualDesdeJSON().stream().anyMatch(libro -> Integer.parseInt(libro.getCantidadEnBiblioteca()) > 0)) {
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
     * <p>
     * ESTO AL CREAR UN LIBRO
     * </p>
     *
     * @param libroEvaluado
     * @return
     */
    public static Boolean verificaCantidadEnDisponible(Libro libroEvaluado) {

        if (Integer.parseInt(libroEvaluado.getCantidadDisponiblePrestamo()) > 0
                && Integer.parseInt(libroEvaluado.getCantidadDisponiblePrestamo())
                <= Integer.parseInt(libroEvaluado.getCantidadEnBiblioteca())) {
            System.out.println("LIBRO INGRESADO TIENE DISPONIBLE: "
                    + libroEvaluado.getCantidadDisponiblePrestamo()
                    + " de " + libroEvaluado.getCantidadEnBiblioteca() + " EN BIBLIOTECA");
            return true;
        }


        throw new IllegalArgumentException(
                ("EL VALOR INGRESADO NO ES VÁLIDO, NO PUEDE SER UN VALOR IGUAL A MENOR A " +
                        "0 NI MAYOR QUE LA CANTIDAD DISPONIBLE EN BIBLIOTECA " + libroEvaluado.getCantidadEnBiblioteca())
        );
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

        Boolean flag = true;

        for (Libro libroEvaluado : leeListaActualDesdeJSON()) {

            if (leeListaActualDesdeJSON().stream().anyMatch(libro -> libro.getISBN().equalsIgnoreCase(libroIngresado.getISBN()))) {
                leeListaActualDesdeJSON().remove(leeListaActualDesdeJSON().indexOf(libroEvaluado));
                System.out.println("LIBRO " + libroIngresado.getISBN() + " ELIMINADO SATISFACTORIAMENTE");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("LIBRO NO EXISTE PARA SER ELIMINADO");
        }
        actualizaJSON();
    }

    /**
     * <p>
     * Si el libro no existe arroja na excepcion NoSuchElementException
     * </p>
     *
     * @param isbn
     * @return
     */
    public static Libro buscaLibro(String isbn) {
        for (Libro libro : leeListaActualDesdeJSON()) {
            if (libro.getISBN().equalsIgnoreCase(isbn) || verificaISBN(isbn)) {
                return libro;
            }
        }
        throw new NoSuchElementException("Libro no encontrado");
    }
}
