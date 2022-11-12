package com.grupo15.unab.usuarios;

import com.grupo15.unab.interfaces.UsuarioInterface;
import com.grupo15.unab.transacciones.Prestamo;

/**
 * @author Grupo 15
 */
public class Docente extends Usuario implements UsuarioInterface {

    private String gradoAcademico;

    public Docente(String run, String nombre, String genero, Prestamo prestamo, String gradoAcademico) {
        super(run, nombre, genero, prestamo);
        this.gradoAcademico = gradoAcademico;
    }

    public String getGrado() {
        return gradoAcademico;
    }

    public void setGrado(String grado) {
        this.gradoAcademico = grado;
    }


    //    /**
//     * <p>
//     * El docente pide el libro segun los requerimientos para este tipo de usuario
//     * </p>
//     */
//    @Override
//    public void pedirLibro() {
//
//        // Llamar método en préstamo
//    }
//
//    /**
//     * <p>
//     * El docente devuelve el libro según los requerimientos para este tipo de usuario
//     * </p>
//     */
//    @Override
//    public void devolverLibro() {
//
//        // Llamar método en devolución
//    }

    @Override
    public void pedirLibro(Integer ISBN, String run) {

    }

    @Override
    public void devolverLibro() {

    }

    @Override
    public String toString() {
        return "Docente{" + "gradoAcademico='" + gradoAcademico + '\'' + "} " + super.toString();
    }


}
