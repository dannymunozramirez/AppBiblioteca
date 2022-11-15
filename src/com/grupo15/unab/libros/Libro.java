package com.grupo15.unab.libros;

/**
 * @author grupo15
 */
public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int cantidadEnBiblioteca;
    private int cantidadDisponiblePrestamo;
    private String imagen;

    public Libro(String isbn, String titulo, String autor, int cantidadEnBiblioteca, int cantidadDisponiblePrestamo, String imagen) {
        setIsbn(isbn);
        setTitulo(titulo);
        setAutor(autor);
        setCantidadEnBiblioteca(cantidadEnBiblioteca);
        setCantidadDisponiblePrestamo(cantidadDisponiblePrestamo);
        setImagen(imagen);
    }

    //busqueda de libro se encuentra en clase Prestamo****
    //Cantidad en biblioteca lo debo obtener desde metodo en Prestamo***
    //Cantidad disponible lo debo obtener desde metodo en Prestamo***
    //eliminar libro lo debo configurar desde metodo en Prestamo***

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidadEnBiblioteca() {
        return cantidadEnBiblioteca;
    }

    public void setCantidadEnBiblioteca(int cantidadEnBiblioteca) {
        this.cantidadEnBiblioteca = cantidadEnBiblioteca;
    }

    public int getCantidadDisponiblePrestamo() {
        return cantidadDisponiblePrestamo;
    }

    public void setCantidadDisponiblePrestamo(int cantidadDisponiblePrestamo) {
        this.cantidadDisponiblePrestamo = cantidadDisponiblePrestamo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
