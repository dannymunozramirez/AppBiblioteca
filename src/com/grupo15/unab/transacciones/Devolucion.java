package com.grupo15.unab.transacciones;

/**
 * @author dannymunoz
 */
public class Devolucion {

    private Libro libro;
    private Usuario usuario;

    public Libro(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public static Libro validarLibro(int ISBN, ArrayList<Libro> libros) {
        // BUSCO EL LIBRO EN EL ARREGLO DE LIBROS
        for (int i = 0; i < libros.size(); i++) {
            // VOY OBTENIENDO CADA LIBRO EN EL ARREGLO DE LIBROS
            Libro libro = libros.get(i);

            // PREGUNTO SI EL ISBN DEL LIBRO ES IGUAL AL LIBRO QUE BUSCO
            if (libro.getIsbn() == ISBN) {
                // SI LO ENCUENTRO, LO RETORNO
                return libro;
            }
        }

        // SI NO LO ENCUENTRO, RETORNO UN MENSAJE
        throw new IllegalArgumentException("El libro a buscar no existe.");
    }
}