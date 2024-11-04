package atividade01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {
    private Queue queue;

    @BeforeEach
    public void setUp() {
        queue = new Queue();
    }

    @Test
    public void testEnqueueAndDequeue() {
        Filme filme = new Filme(1, "Inception", 5, 2010);
        queue.enqueue(filme);
        assertEquals(filme, queue.dequeue());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(new Filme(1, "Inception", 5, 2010));
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testDisplay() {
        queue.enqueue(new Filme(1, "Inception", 5, 2010));
        queue.enqueue(new Filme(2, "Interstellar", 5, 2014));
        String expectedOutput = "Filme{id=1, nome='Inception', nota=5, ano=2010}\n" +
                                "Filme{id=2, nome='Interstellar', nota=5, ano=2014}\n";
        assertEquals(expectedOutput, queue.display());
    }
}