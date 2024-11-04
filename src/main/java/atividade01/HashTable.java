package atividade01;

public class HashTable {
    private DoublyLinkedList<Filme>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.size = size;
        table = new DoublyLinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new DoublyLinkedList<>();
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
        return table[index].find(new Filme(id, null, 0, 0));
    }

    public void delete(int id) {
        int index = hash(id);
        table[index].remove(new Filme(id, null, 0, 0));
    }

    public String display() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(table[i].display());
        }
        return result.toString();
    }
}

