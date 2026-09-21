package com.example.demo.entities;

import com.example.demo.classes.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "filmes") @Entity
public class MovieEntity {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo, ano, tipo, imdbId;
    private Double rating;

    public MovieEntity(){
    }
    public MovieEntity(Movie movie){
        this.titulo = movie.getTitle();
        this.ano = movie.getYear();
        this.imdbId = movie.getImdbID();
        this.tipo = movie.getType();
        if(movie.getImdbRating() == null){
            this.rating = null;
        }else{
            this.rating = Double.parseDouble(movie.getImdbRating());
        }
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getAno() {
        return ano;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
}

