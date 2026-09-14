package com.example.demo.controller;
import com.example.demo.classes.Movie;
import com.example.demo.services.OmdbService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private final OmdbService omdbService;

    public HelloController(OmdbService omdbService) {
        this.omdbService = omdbService;
    }

    @GetMapping("/filmes/buscar/{title}")
    public List<Movie> pegarFilmes(@PathVariable String title) throws IOException, InterruptedException {

        List<Movie> filmesListados = omdbService.procurarPalavraChave(title);
        return filmesListados;
    }

    @GetMapping("/filmes/detalhe/{imdbID}")
    public Movie procurarPorID(@PathVariable String imdbID) throws IOException, InterruptedException {
        Movie filmeID = omdbService.procurarPorID(imdbID);

        return filmeID;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> errorMessage(RuntimeException e) {
        String erro = e.getMessage();

        return ResponseEntity.status(404).body(erro);
    }
}
