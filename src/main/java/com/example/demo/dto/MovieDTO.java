package com.example.demo.dto;

import com.example.demo.entities.MovieEntity;

public class MovieDTO{
    private String titulo, ano, tipo, imdbId;
    private Double rating;

    public MovieDTO(){
    }

    public MovieDTO(MovieEntity movieEntity){
        this.titulo = movieEntity.getTitulo();
        this.ano = movieEntity.getAno();
        this.imdbId = movieEntity.getImdbId();
        this.tipo = movieEntity.getTipo();
        this.rating = movieEntity.getRating();
        }

    public String getTitulo() {
        return titulo;
    }

    public String getAno() {
        return ano;
    }

    public String getTipo() {
        return tipo;
    }

    public String getImdbId() {
        return imdbId;
    }

    public Double getRating() {
        return rating;
    }
}

