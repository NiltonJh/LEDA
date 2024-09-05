package atividade01;

public class Filme implements Comparable<Filme> {
    private String nome;
    private int nota;
    private int ano;

    public Filme(String nome, int nota, int ano) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int compareTo(Filme outro) {
        if (this.nota != outro.nota) {
            return Integer.compare(outro.nota, this.nota); // Nota decrescente
        } else if (this.ano != outro.ano) {
            return Integer.compare(this.ano, outro.ano); // Ano crescente
        } else {
            return this.nome.compareTo(outro.nome); // Nome crescente
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%d) [%d]", nome, ano, nota);
    }
}

