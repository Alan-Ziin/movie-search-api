package com.example.demo.controller;
import com.example.demo.classes.Movie;
import com.example.demo.services.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/hello")
    public String oi(){
        return "Oi";
    }

    @GetMapping("/filmes/{title}")
    public List<Movie> pegarFilmes(@PathVariable String title) throws IOException, InterruptedException {

        List<Movie> filmesListados = omdbService.procurarPalavraChave(title);
        return filmesListados;
    }
}
