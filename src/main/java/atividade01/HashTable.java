package atividade01;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Filme>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Filme filme) {
        int index = hash(filme.getId());
        table[index].add(filme);
    }

    public Filme search(int id) {
        int index = hash(id);
        for (Filme filme : table[index]) {
            if (filme.getId() == id) {
                return filme;
            }
        }
        return null;
    }

    public void delete(int id) {
        int index = hash(id);
        table[index].removeIf(filme -> filme.getId() == id);
    }

    public String display() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (Filme filme : table[i]) {
                result.append(filme).append("\n");
            }
        }
        return result.toString();
    }
}

