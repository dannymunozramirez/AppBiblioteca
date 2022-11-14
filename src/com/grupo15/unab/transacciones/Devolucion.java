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
    public static Usuario ValidarUsuario(String rut, ArrayList<Usuario> usuarios) {
        // BUSCO EL USUARIO EN EL ARREGLO DE USUARIOS
        for (int i = 0; i < usuarios.size(); i++) {
            // VOY OBTENIENDO CADA USUARIO EN EL ARREGLO DE USUARIOS
            Usuario usuario = usuarios.get(i);

            // PREGUNTO SI EL RUT DEL USUARIO ES IGUAL AL RUN QUE BUSCO
            if (usuario.getRut() == rut) {
                // SI LO ENCUENTRO, LO RETORNO
                return usuario;
            }
        }

        // SI NO LO ENCUENTRO, RETORNO UN MENSAJE
        throw new IllegalArgumentException("El usuario a buscar no existe.");
    }

}