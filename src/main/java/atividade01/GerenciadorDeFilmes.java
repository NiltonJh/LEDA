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

            System.out.println("1. Inserir Filme");
            System.out.println("2. Buscar Filme");
            System.out.println("3. Remover Filme");
            System.out.println("4. Exibir Filmes Ordenados");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Digite o ID, Nome, Nota e Ano do Filme: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    String nome = scanner.nextLine();
                    int nota = scanner.nextInt();
                    int ano = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    Filme filme = new Filme(id, nome, nota, ano);
                    gerenciador.inserirFilme(filme);
                    break;
                case 2:
                    System.out.println("Digite o ID do Filme: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    Filme encontrado = gerenciador.buscarFilme(id);
                    System.out.println(encontrado != null ? encontrado : "Filme não encontrado");
                    break;
                case 3:
                    System.out.println("Digite o ID do Filme: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    gerenciador.removerFilme(id);
                    break;
                case 4:
                    System.out.println(gerenciador.exibirFilmesOrdenados());
                    break;
                case 5:
                    scanner.close();
                    return;
            }
        }
    }
}