package com.grupo15.unab.libros;

/**
 * @author Grupo 15
 */
public class Libro {
    private Integer ISBN;
    private String nombre;
    private String autor;
    private Integer cantidadEnBiblioteca;
    private Integer cantidadDisponiblePrestamo;

    public Libro(Integer ISBN, String nombre, String autor, Integer cantidadEnBiblioteca, Integer cantidadDisponiblePrestamo) {
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.autor = autor;
        this.cantidadEnBiblioteca = cantidadEnBiblioteca;
        this.cantidadDisponiblePrestamo = cantidadDisponiblePrestamo;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    //        Libro arteEnJava = new Libro(131, "Arte en Java", "Codd", 5, 5);
//        Libro programacionEnJava = new Libro(386, "Programacion en Java", "Luis Joyanes", 2, 2);
//        Map<Libro, Integer> mapLibros = new HashMap<>();
//        mapLibros.put(arteEnJava, 50);
//        mapLibros.put(programacionEnJava, 50);
}
