package atividade01;

public class BST {
    private class BSTNode {
        Filme filme;
        BSTNode left, right;

        BSTNode(Filme filme) {
            this.filme = filme;
            left = right = null;
        }
    }

    private BSTNode root;

    public void insert(Filme filme) {
        root = insertRec(root, filme);
    }

    private BSTNode insertRec(BSTNode root, Filme filme) {
        if (root == null) {
            root = new BSTNode(filme);
            return root;
        }
        if (filme.getId() < root.filme.getId()) {
            root.left = insertRec(root.left, filme);
        } else if (filme.getId() > root.filme.getId()) {
            root.right = insertRec(root.right, filme);
        }
        return root;
    }

    public Filme search(int id) {
        return searchRec(root, id);
    }

    private Filme searchRec(BSTNode root, int id) {
        if (root == null || root.filme.getId() == id) {
            return root != null ? root.filme : null;
        }
        if (root.filme.getId() > id) {
            return searchRec(root.left, id);
        }
        return searchRec(root.right, id);
    }

    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private BSTNode deleteRec(BSTNode root, int id) {
        if (root == null) {
            return root;
        }
        if (id < root.filme.getId()) {
            root.left = deleteRec(root.left, id);
        } else if (id > root.filme.getId()) {
            root.right = deleteRec(root.right, id);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.filme = minValue(root.right);
            root.right = deleteRec(root.right, root.filme.getId());
        }
        return root;
    }

    private Filme minValue(BSTNode root) {
        Filme minv = root.filme;
        while (root.left != null) {
            minv = root.left.filme;
            root = root.left;
        }
        return minv;
    }

    public String inorder() {
        StringBuilder result = new StringBuilder();
        inorderRec(root, result);
        return result.toString();
    }

    private void inorderRec(BSTNode root, StringBuilder result) {
        if (root != null) {
            inorderRec(root.left, result);
            result.append(root.filme).append("\n");
            inorderRec(root.right, result);
        }
    }
}
