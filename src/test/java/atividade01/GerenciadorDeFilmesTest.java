package atividade01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GerenciadorDeFilmesTest {
    private GerenciadorDeFilmes gerenciador;

    @BeforeEach
    public void setUp() {
        gerenciador = new GerenciadorDeFilmes();
    }

    @Test
    public void testInserirBuscarRemoverFilmeBST() {
        gerenciador.setEstrutura("BST");
        Filme filme = new Filme(1, "Inception", 5, 2010);
        gerenciador.inserirFilme(filme);
    }
}