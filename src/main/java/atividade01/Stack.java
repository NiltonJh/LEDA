package atividade01;

import java.util.LinkedList;

public class Stack {
    private LinkedList<Filme> list = new LinkedList<>();

    public void push(Filme filme) {
        list.addFirst(filme);
    }

    public Filme pop() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}