package atividade01;

import java.util.LinkedList;

public class Queue {
    private LinkedList<Filme> stack1 = new LinkedList<>();
    private LinkedList<Filme> stack2 = new LinkedList<>();

    public void enqueue(Filme filme) {
        stack1.push(filme);
    }

    public Filme dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        return null; // Retorna null se a fila estiver vazia
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public String display() {
        LinkedList<Filme> tempStack = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        while (!isEmpty()) {
            Filme filme = dequeue();
            result.append(filme).append("\n");
            tempStack.push(filme);
        }
        while (!tempStack.isEmpty()) {
            enqueue(tempStack.pop());
        }
        return result.toString();
    }
}