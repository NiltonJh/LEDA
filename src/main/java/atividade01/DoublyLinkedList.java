package atividade01;

public class DoublyLinkedList<T> {
    private class Node {
        T data;
        Node prev, next;

        Node(T data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    private Node head, tail;

    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean remove(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T find(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        return data;
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        }
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String display() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.data).append("\n");
            current = current.next;
        }
        return result.toString();
    }
}
