package com.cinema.cine.Entity;

import jakarta.persistence.*;

@Table(name = "peliculas")
@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_pelicula")
    private int Id_pelicula;
    @Column(name = "Titulo")
    private String Titulo;
    @Column(name = "Directores")
    private String Directores;
    @Column(name = "Actores")
    private String Actores;
    @Column(name = "Descripcion")
    private String Descripcion;
    @Column(name = "Genero")
    private String Genero;
    @Column(name = "Imagen")
    private String Imagen;
    @Column(name = "Video")
    private String Video;
    @Column(name = "Estado")
    private int Estado;

    public int getIdPelicula() {
        return Id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        Id_pelicula = id_pelicula;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDirectores() {
        return Directores;
    }

    public void setDirectores(String directores) {
        Directores = directores;
    }

    public String getActores() {
        return Actores;
    }

    public void setActores(String actores) {
        Actores = actores;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }
}

