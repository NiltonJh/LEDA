package atividade01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilmeTest {

    @Test
    public void testCompareTo() {
        Filme f1 = new Filme("A", 5, 2020);
        Filme f2 = new Filme("B", 4, 2021);
        Filme f3 = new Filme("C", 5, 2019);
        Filme f4 = new Filme("D", 5, 2020);
        Filme f5 = new Filme("A", 5, 2020);

        assertTrue(f1.compareTo(f2) < 0); // f1 deve vir antes de f2 devido à nota maior
        assertTrue(f2.compareTo(f1) > 0); // f2 deve vir depois de f1 devido à nota menor

        assertTrue(f1.compareTo(f3) > 0); // f1 deve vir depois de f3 devido ao ano mais recente
        assertTrue(f3.compareTo(f1) < 0); // f3 deve vir antes de f1 devido ao ano mais antigo

        assertTrue(f1.compareTo(f4) < 0); // f1 deve vir antes de f4 devido ao nome em ordem alfabética
        assertTrue(f4.compareTo(f1) > 0); // f4 deve vir depois de f1 devido ao nome em ordem alfabética
    }
}