package com.grupo15.unab.libros;

import com.grupo15.unab.servicios.ServiciosLibro;

/**
 * @author Grupo 15
 */
public class Libro {

    private String ISBN;
    private String titulo;
    private String autor;
    private String cantidadEnBiblioteca;
    private String cantidadDisponiblePrestamo;
    private String imagen;

    public Libro(String ISBN, String titulo, String autor, String cantidadEnBiblioteca, String cantidadDisponiblePrestamo, String imagen) {
        this.setISBN(ISBN);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setCantidadEnBiblioteca(cantidadEnBiblioteca);
        this.setCantidadDisponiblePrestamo(cantidadDisponiblePrestamo);
        this.setImagen(imagen);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public String getCantidadEnBiblioteca() {
        return cantidadEnBiblioteca;
    }

    public void setCantidadEnBiblioteca(String cantidadEnBiblioteca) {
        if (ServiciosLibro.verificaCantidadEnBiblioteca(ServiciosLibro.buscaLibro(getISBN()))) {
            this.cantidadEnBiblioteca = cantidadEnBiblioteca;
        }
    }

    public String getCantidadDisponiblePrestamo() {
        return cantidadDisponiblePrestamo;
    }

    public void setCantidadDisponiblePrestamo(String cantidadDisponiblePrestamo) {
        this.cantidadDisponiblePrestamo = cantidadDisponiblePrestamo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
