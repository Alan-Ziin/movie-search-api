package com.example.demo.controller;
import com.example.demo.classes.Movie;
import com.example.demo.services.MovieComparators;
import com.example.demo.services.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private final OmdbService omdbService;

    public Controller(OmdbService omdbService) {
        this.omdbService = omdbService;
    }

    // busca filmes por palavra-chave (busca "rasa")
    @GetMapping("/filmes/buscar/{title}")
    public List<Movie> pegarFilmes(@PathVariable String title) throws IOException, InterruptedException {

        List<Movie> filmesListados = omdbService.procurarPalavraChave(title);
        return filmesListados;
    }

    // busca um filme específico por ID (busca "profunda", pegando todas as info do filme)
    @GetMapping("/filmes/detalhe/{imdbID}")
    public Movie procurarPorID(@PathVariable String imdbID) throws IOException, InterruptedException {
        Movie filmeID = omdbService.procurarPorID(imdbID);

        return filmeID;
    }

    // intercepta qualquer RuntimeException lançada aqui no Controller
    // e devolve 404 com mensagem clara, em vez da tela de erro padrão
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> errorMessage(RuntimeException e) {
        String erro = e.getMessage();

        return ResponseEntity.status(404).body(erro);
    }

    // buscar filmes por ano e organizando os mesmos, aqui possui conceito de N+1 à API
    // (1 pra busca + 1 por filme encontrado), pode deixar a API lenta dependendo de quantos resultados
    // for retornar.
    @GetMapping("/filmes/buscarPorAno")
    public List<Movie> compareMoviesYear(@RequestParam String title ) throws IOException, InterruptedException{
        List<Movie> moviesYears = omdbService.procurarPalavraChave(title);

        moviesYears.sort(MovieComparators.porAno()); // Organizando filmes por ano

        List<Movie> moviesYearsAndRating = new ArrayList<>();

        for(Movie moviesRating : moviesYears){ // laço para buscar por ID e conseguir o Rating "&i= ID específico"
            Movie filmesPorID = omdbService.procurarPorID(moviesRating.getImdbID());

            moviesYearsAndRating.add(filmesPorID);
        }
        return moviesYearsAndRating;
    }
}
