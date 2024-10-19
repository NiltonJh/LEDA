package atividade01;

class BSTNode {
    Filme filme;
    BSTNode left, right;

    public BSTNode(Filme filme) {
        this.filme = filme;
        left = right = null;
    }
}
