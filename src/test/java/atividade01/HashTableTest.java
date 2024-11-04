package atividade01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashTableTest {
    private HashTable hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new HashTable(10);
    }

    @Test
    public void testInsertAndSearch() {
        Filme filme = new Filme(1, "Inception", 5, 2010);
        hashTable.insert(filme);
        assertEquals(filme, hashTable.search(1));
    }

    @Test
    public void testDelete() {
        Filme filme = new Filme(1, "Inception", 5, 2010);
        hashTable.insert(filme);
        hashTable.delete(1);
        assertNull(hashTable.search(1));
    }

    @Test
    public void testDisplay() {
        hashTable.insert(new Filme(1, "Inception", 5, 2010));
        hashTable.insert(new Filme(2, "Interstellar", 5, 2014));
        String expectedOutput = "Filme{id=1, nome='Inception', nota=5, ano=2010}\n" +
                                "Filme{id=2, nome='Interstellar', nota=5, ano=2014}\n";
        assertEquals(expectedOutput, hashTable.display());
    }
}