package com.grupo15.unab.servicios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo15.unab.data.LectorArchivosJSON;
import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.transacciones.Devolucion;
import com.grupo15.unab.transacciones.Prestamo;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Estudiante;
import com.grupo15.unab.usuarios.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.time.*;
import java.util.*;


/**
 * <p>
 * Esta clase contiene todos los métodos estáticos para ser usados con la Clase Prestamo
 * </p>
 *
 * <p>
 * Consideraciones: El libro debe existir =
 * </p>
 *
 * @author grupo 15
 */
public final class ServiciosPrestamo {

    /**
     * <p>
     * Este método recibe el run e isbn del libro a prestar
     * luego devuelve un arriendo generado (nueva instancia)
     * </p>
     *
     * @param run
     * @param isbn
     */
    public static Prestamo generaUnArriendo(String run, String isbn) throws IOException {

        /**
         * <p>
         *     Quien esta solicitando el arriendo
         * </p>
         */
        Usuario usuario = ServiciosUsuarios.buscaUsuario(run);
        Libro libro = ServiciosLibro.buscaLibro(isbn);

        System.out.println(!verificaCantidadEnBiblioteca(libro) + " 11111");
        System.out.println(verificaISBNLibroExiste(libro) + " 11111");
        System.out.println(verificaCantidadEnDisponible(libro) + " 11111");
        System.out.println(ServiciosUsuarios.verificaRunExiste(run) + " 11111");

        /**
         * Validaciones antes de generar el prestamo
         */
        if (!verificaCantidadEnBiblioteca(libro) &&
                verificaISBNLibroExiste(libro) &&
                verificaCantidadEnDisponible(libro) &&
                ServiciosUsuarios.verificaRunExiste(run) &&
                verificarUsuarioHabilitado(usuario)) {

            System.out.println("INGRESAMOS!!!!");
            usuario.setPrestamos(isbn);
            libro.setCantidadDisponiblePrestamo(String.valueOf(Integer.parseInt(libro.getCantidadDisponiblePrestamo()) - 1));
            ServiciosLibro.actualizarLibro(libro);
            ServiciosUsuarios.actualizarUsuario(usuario);
        } else {
//            throw new IllegalArgumentException(" ");
            System.out.println("No Arrendado");
        }
        LocalDate localDate = cantidadDeDias(usuario);
        return new Prestamo(libro, usuario, localDate);
    }

    public static LocalDate cantidadDeDias(Usuario usuario) {
        LocalDate date = LocalDate.now();
        LocalDate date2 = null;

        if (usuario instanceof Docente) {
            date2 = date.plusDays(20);
        } else {
            date2 = date.plusDays(10);
        }

        return date2;
    }

    /**
     * Retorna true si el usuario tiene un prestamos vigente
     *
     * @return
     */
    public static Boolean verificarUsuarioHabilitado(Usuario usuario) {

        if (usuario.getPrestamos().equalsIgnoreCase("0")) {
            return true;
        }
        return false;
    }

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
     * Verifica ISBN repetidos
     * II
     * </P>
     *
     * @throws IOException
     */
    public static Boolean verificaISBNLibroExiste(Libro libroEvaluado) {

        List<Libro> libros = creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"))
                .isEmpty() ? new ArrayList<>()
                : creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"));

        // Verifica ISBN
        if (libros.stream().anyMatch(libro -> libro.getISBN().equalsIgnoreCase(libroEvaluado.getISBN()))) {

            System.out.println("EL LIBRO " + libroEvaluado.getISBN() +
                    " EXISTE");
            return true;
        }
        return false;
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
        if (libros.stream().anyMatch(libro -> Integer.parseInt(libro.getCantidadEnBiblioteca()) == 0)) {
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
//        libros.stream().anyMatch(libro -> (Integer.valueOf(libro.getCantidadDisponiblePrestamo()) > 0
//                && Integer.valueOf(libro.getCantidadDisponiblePrestamo()) <= Integer.valueOf(libroEvaluado.getCantidadEnBiblioteca()))


        if (Integer.valueOf(libroEvaluado.getCantidadDisponiblePrestamo()) > 0 && Integer.valueOf(libroEvaluado.getCantidadDisponiblePrestamo()) <= Integer.valueOf(libroEvaluado.getCantidadEnBiblioteca())) {
            System.out.println("LIBRO DISPONIBLE HAY: "
                    + libroEvaluado.getCantidadDisponiblePrestamo()
                    + " de " + libroEvaluado.getCantidadEnBiblioteca());
            return true;
        } else {
            System.out.println("EL VALOR INGRESADO NO ES VÁLIDO, NO PUEDE SER UN VALOR IGUAL A MENOR A " +
                    "0 NI MAYOR QUE LA CANTIDAD DISPONIBLE EN BIBLIOTECA " + libroEvaluado.getCantidadEnBiblioteca());
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
