package atividade01;

public class Queue {
    private DoublyLinkedList<Filme> stack1 = new DoublyLinkedList<>();
    private DoublyLinkedList<Filme> stack2 = new DoublyLinkedList<>();

    public void enqueue(Filme filme) {
        stack1.add(filme);
    }

    public Filme dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.removeLast());
            }
        }
        return stack2.removeFirst();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public String display() {
        DoublyLinkedList<Filme> tempStack = new DoublyLinkedList<>();
        StringBuilder result = new StringBuilder();
        while (!isEmpty()) {
            Filme filme = dequeue();
            result.append(filme).append("\n");
            tempStack.add(filme);
        }
        while (!tempStack.isEmpty()) {
            enqueue(tempStack.removeFirst());
        }
        return result.toString();
    }
}