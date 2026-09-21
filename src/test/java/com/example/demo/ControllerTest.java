package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testeBuscarPorAno() throws Exception {
        mockMvc.perform(get("/filmes/buscarPorAno?title=Matrix"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("1999")));
    }

    @Test
    public void testeBuscarFilmes() throws Exception {
        mockMvc.perform(get("/filmes/buscar/matrix"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Matrix")));
    }

    @Test
    public void testeBuscarPorID() throws Exception{
        mockMvc.perform(get("/filmes/detalhe/tt0133093"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("tt0133093")));
    }
}
