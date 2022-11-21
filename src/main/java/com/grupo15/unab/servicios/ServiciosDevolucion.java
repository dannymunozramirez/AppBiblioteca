package com.grupo15.unab.servicios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo15.unab.data.LectorArchivosJSON;
import com.grupo15.unab.libros.Libro;
import com.grupo15.unab.transacciones.Devolucion;
import com.grupo15.unab.transacciones.Prestamo;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;


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
public final class ServiciosDevolucion {

    /**
     * <p>
     * Este método recibe el run e isbn del libro a prestar
     * luego devuelve un arriendo generado (nueva instancia)
     * </p>
     */
    public static void devolverLibro(Prestamo prestamo) throws IOException {

        if (prestamo.getUsuario().getPrestamos().equalsIgnoreCase(prestamo.getLibro().getISBN())) {
            System.out.println("CORRESPONDE");
            agregarLibroDevuelto(prestamo.getLibro().getISBN());
            resetISBNUsuario(prestamo.getUsuario());

        }
        laMulta(prestamo);

    }

    /**
     * @param usuario
     * @throws IOException
     */
    public static void resetISBNUsuario(Usuario usuario) throws IOException {
        usuario.setPrestamos("0");
        ServiciosUsuarios.actualizarUsuario(usuario);
    }

    public static void agregarLibroDevuelto(String isbn) throws IOException {

        Libro libro = ServiciosLibro.buscaLibro(isbn);
        System.out.println(libro.getCantidadDisponiblePrestamo() + " ANTES");
//        String cantidad = libro.getCantidadDisponiblePrestamo();

        libro.setCantidadDisponiblePrestamo(String.valueOf(Integer.parseInt(libro.getCantidadDisponiblePrestamo()) + 1));
        System.out.println(libro.getCantidadDisponiblePrestamo() + " DESPUES");
        ServiciosLibro.actualizarLibro(libro);
    }

    /**
     * <p>
     *
     * </p>
     *
     * @param prestamo
     * @return
     */
    public static String laMulta(Prestamo prestamo) {
        String msn = "No hay multa";
        Long aLong;
        LocalDate date = LocalDate.now();
        LocalDate fechaDevolucion = prestamo.getFecha();

        if (date.isAfter(fechaDevolucion)) {
            long between = DAYS.between(fechaDevolucion, date);
            aLong = between * 1000;
            return "Días de retraso son: " + between + " la multa es: " + aLong;
        }

        System.out.println(date);
        System.out.println("No hay multa");
        return msn;
    }
}
