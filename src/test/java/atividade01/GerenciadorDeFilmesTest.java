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

        Filme encontrado = gerenciador.buscarFilme(1);
        assertEquals(filme, encontrado);

        gerenciador.removerFilme(1);
        assertNull(gerenciador.buscarFilme(1));
    }

    @Test
    public void testInserirBuscarRemoverFilmeHashTable() {
        gerenciador.setEstrutura("HashTable");
        Filme filme = new Filme(1, "Inception", 5, 2010);
        gerenciador.inserirFilme(filme);

        Filme encontrado = gerenciador.buscarFilme(1);
        assertEquals(filme, encontrado);

        gerenciador.removerFilme(1);
        assertNull(gerenciador.buscarFilme(1));
    }

    @Test
    public void testInserirBuscarRemoverFilmeQueue() {
        gerenciador.setEstrutura("Queue");
        Filme filme = new Filme(1, "Inception", 5, 2010);
        gerenciador.inserirFilme(filme);

        Filme encontrado = gerenciador.buscarFilme(1);
        assertEquals(filme, encontrado);

        gerenciador.removerFilme(1);
        assertNull(gerenciador.buscarFilme(1));
    }

    @Test
    public void testExibirFilmesOrdenadosBST() {
        gerenciador.setEstrutura("BST");
        gerenciador.inserirFilme(new Filme(2, "Interstellar", 5, 2014));
        gerenciador.inserirFilme(new Filme(1, "Inception", 5, 2010));
        gerenciador.inserirFilme(new Filme(3, "Dunkirk", 4, 2017));

        String expectedOutput = "Inception (2010) [5]\n" +
                                "Interstellar (2014) [5]\n" +
                                "Dunkirk (2017) [4]\n";
        String actualOutput = gerenciador.exibirFilmesOrdenados();
        assertEquals(expectedOutput, actualOutput);
    }
}