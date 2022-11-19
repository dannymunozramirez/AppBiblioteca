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

        List<Libro> librosEnJson = new ArrayList<>();

        if (jsonObjectArray != null || !jsonObjectArray.isEmpty()) {
            jsonObjectArray.forEach(libro -> {
                JSONObject jsonObject = (JSONObject) libro;
                Integer ISBN = (Integer) jsonObject.get("ISBN");
                String titulo = (String) jsonObject.get("titulo");
                String autor = (String) jsonObject.get("autor");
                Integer cantidadEnBiblioteca = (Integer) jsonObject.get("cantidadEnBiblioteca");
                Integer disponiblePrestamos = (Integer) jsonObject.get("disponiblePrestamos");
                String imagen = (String) jsonObject.get("imagen");

                Libro libroDeJSONDocente = new Libro(ISBN, titulo, autor, cantidadEnBiblioteca, disponiblePrestamos, imagen);
                librosEnJson.add(libroDeJSONDocente);

            });
        }
        return librosEnJson;
    }

    public static List<Libro> creaLista() {
        /**
         * <p>
         *  Crea y pobla una lista. Si la lista esta vacía, crea una nueva lista de lo contrario le asigna los
         *  valores existentes en json a la lista libros
         * </p>
         */
        List<Libro> libros = creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"))
                .isEmpty() ? new ArrayList<>()
                : creaListaLibros(LectorArchivosJSON.lectorJSON("src/main/resources/libros.json"));
        return libros;
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

        // Verifica ISBN
        if (creaLista().stream().anyMatch(libro -> libro.getISBN() == libroEvaluado.getISBN())) {
            System.out.println("EL LIBRO " + libroEvaluado.getISBN() +
                    " NO YA EXISTE, NO ES ÚNICO");
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

        // VERIFICA CANTIDAD EN BIBLIOTECA
        if (creaLista().stream().anyMatch(libro -> libro.getCantidadEnBiblioteca() == 0)) {
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

        // VERIFICA CANTIDAD EN BIBLIOTECA
        if (creaLista().stream().anyMatch(libro -> (libro.getCantidadDisponiblePrestamo() == 0
                || libro.getCantidadEnBiblioteca() <= libroEvaluado.getCantidadEnBiblioteca()))) {
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

        Boolean flag = true;

        for (Libro libroEvaluado : creaLista()) {

            if (creaLista().stream().anyMatch(libro -> libro.getISBN() == libroIngresado.getISBN())) {
                creaLista().remove(creaLista().indexOf(libroEvaluado));
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
         *     mapper.writeValue(new File("src/main/resources/usuarios.json"), usuarios);
         *     Esta línea permite escribir el archivo JSON con la nueva version de la lista
         * </p>
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/main/resources/usuarios.json"), creaLista());

    }
}
