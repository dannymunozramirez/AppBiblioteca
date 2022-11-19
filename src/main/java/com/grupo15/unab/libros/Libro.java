package com.grupo15.unab.libros;

/**
 * @author Grupo 15
 */
public class Libro {

    private Integer ISBN;
    private String titulo;
    private String autor;
    private Integer cantidadEnBiblioteca;
    private Integer cantidadDisponiblePrestamo;

    private String imagen;

    public Libro(Integer ISBN, String titulo, String autor, Integer cantidadEnBiblioteca, Integer cantidadDisponiblePrestamo, String imagen) {
        this.setISBN(ISBN);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setCantidadEnBiblioteca(cantidadEnBiblioteca);
        this.setCantidadDisponiblePrestamo(cantidadDisponiblePrestamo);
        this.setImagen(imagen);
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
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

    public Integer getCantidadEnBiblioteca() {
        return cantidadEnBiblioteca;
    }

    public void setCantidadEnBiblioteca(Integer cantidadEnBiblioteca) {
        this.cantidadEnBiblioteca = cantidadEnBiblioteca;
    }

    public Integer getCantidadDisponiblePrestamo() {
        return cantidadDisponiblePrestamo;
    }

    public void setCantidadDisponiblePrestamo(Integer cantidadDisponiblePrestamo) {
        this.cantidadDisponiblePrestamo = cantidadDisponiblePrestamo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
