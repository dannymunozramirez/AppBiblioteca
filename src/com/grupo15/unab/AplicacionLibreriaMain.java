package com.grupo15.unab;

import com.grupo15.unab.transacciones.Prestamo;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Usuario;

/**
 * @author Grupo 15
 */
public class AplicacionLibreriaMain {

    public static void main(String[] args) {
        Usuario usuario = new Docente("1-2","Test","M", new Prestamo(),"magister");

        System.out.println(usuario);
    }


}
