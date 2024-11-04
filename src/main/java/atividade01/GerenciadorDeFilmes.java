package atividade01;

import java.util.Scanner;

public class GerenciadorDeFilmes {
    private BST bst = new BST();
    private HashTable hashTable = new HashTable(10);
    private Queue queue = new Queue();
    private String estruturaAtual = "BST";

    public void setEstrutura(String estrutura) {
        this.estruturaAtual = estrutura;
    }

    public void inserirFilme(Filme filme) {
        switch (estruturaAtual) {
            case "BST":
                bst.insert(filme);
                break;
            case "HashTable":
                hashTable.insert(filme);
                break;
            case "Queue":
                queue.enqueue(filme);
                break;
        }
    }

    public Filme buscarFilme(int id) {
        switch (estruturaAtual) {
            case "BST":
                return bst.search(id);
            case "HashTable":
                return hashTable.search(id);
            case "Queue":
                // Busca linear na fila
                Queue tempQueue = new Queue();
                Filme result = null;
                while (!queue.isEmpty()) {
                    Filme filme = queue.dequeue();
                    if (filme.getId() == id) {
                        result = filme;
                    }
                    tempQueue.enqueue(filme);
                }
                queue = tempQueue;
                return result;
        }
        return null;
    }

    public void removerFilme(int id) {
        switch (estruturaAtual) {
            case "BST":
                bst.delete(id);
                break;
            case "HashTable":
                hashTable.delete(id);
                break;
            case "Queue":
                // Remoção linear na fila
                Queue tempQueue = new Queue();
                while (!queue.isEmpty()) {
                    Filme filme = queue.dequeue();
                    if (filme.getId() != id) {
                        tempQueue.enqueue(filme);
                    }
                }
                queue = tempQueue;
                break;
        }
    }

    public String exibirFilmesOrdenados() {
        String result = "";
        switch (estruturaAtual) {
            case "BST":
                result = bst.inorder();
                break;
            case "HashTable":
                result = hashTable.display();
                break;
            case "Queue":
                result = queue.display();
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        GerenciadorDeFilmes gerenciador = new GerenciadorDeFilmes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha a estrutura de dados (BST, HashTable, Queue): ");
            String estrutura = scanner.nextLine();
            gerenciador.setEstrutura(estrutura);

            System.out.println("Escolha uma operação (inserir, buscar, remover, exibir, sair): ");
            String operacao = scanner.nextLine();

            if (operacao.equals("sair")) {
                break;
            }

            switch (operacao) {
                case "inserir":
                    System.out.println("Digite o id, nome, nota e ano do filme: ");
                    int id = scanner.nextInt();
                    String nome = scanner.next();
                    int nota = scanner.nextInt();
                    int ano = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    Filme filme = new Filme(id, nome, nota, ano);
                    gerenciador.inserirFilme(filme);
                    break;
                case "buscar":
                    System.out.println("Digite o id do filme: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    Filme encontrado = gerenciador.buscarFilme(id);
                    System.out.println(encontrado != null ? encontrado : "Filme não encontrado");
                    break;
                case "remover":
                    System.out.println("Digite o id do filme: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    gerenciador.removerFilme(id);
                    break;
                case "exibir":
                    System.out.println(gerenciador.exibirFilmesOrdenados());
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
        }
        scanner.close();
    }
}