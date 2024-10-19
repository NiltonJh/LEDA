package atividade01;

public class Filme implements Comparable<Filme> {
    private int id;
    private String nome;
    private int nota;
    private int ano;

    public Filme(int id, String nome, int nota, int ano) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getNota() {
        return nota;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public int compareTo(Filme o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", ano=" + ano +
                '}';
    }
}

