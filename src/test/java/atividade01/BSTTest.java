package atividade01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BSTTest {
    private BST bst;

    @BeforeEach
    public void setUp() {
        bst = new BST();
    }

    @Test
    public void testInsertAndSearch() {
        Filme filme = new Filme(1, "Inception", 5, 2010);
        bst.insert(filme);
        assertEquals(filme, bst.search(1));
    }

    @Test
    public void testDelete() {
        Filme filme = new Filme(1, "Inception", 5, 2010);
        bst.insert(filme);
        bst.delete(1);
        assertNull(bst.search(1));
    }

    @Test
    public void testInorder() {
        bst.insert(new Filme(2, "Interstellar", 5, 2014));
        bst.insert(new Filme(1, "Inception", 5, 2010));
        bst.insert(new Filme(3, "Dunkirk", 4, 2017));
        String expectedOutput = "Filme{id=1, nome='Inception', nota=5, ano=2010}\n" +
                                "Filme{id=2, nome='Interstellar', nota=5, ano=2014}\n" +
                                "Filme{id=3, nome='Dunkirk', nota=4, ano=2017}\n";
        assertEquals(expectedOutput, bst.inorder());
    }
}