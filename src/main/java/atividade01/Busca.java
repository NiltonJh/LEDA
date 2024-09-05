package atividade01;

public class Busca {

    public static Filme buscaLinearIterativa(Filme[] filmes, int nota) {
        for (Filme filme : filmes) {
            if (filme.getNota() == nota) {
                return filme;
            }
        }
        return null;
    }

    public static Filme buscaLinearRecursiva(Filme[] filmes, int nota, int index) {
        if (index >= filmes.length) {
            return null;
        }
        if (filmes[index].getNota() == nota) {
            return filmes[index];
        }
        return buscaLinearRecursiva(filmes, nota, index + 1);
    }

    public static Filme buscaBinariaIterativa(Filme[] filmes, int nota) {
        int left = 0;
        int right = filmes.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (filmes[mid].getNota() == nota) {
                return filmes[mid];
            }
            if (filmes[mid].getNota() < nota) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static Filme buscaBinariaRecursiva(Filme[] filmes, int nota, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (filmes[mid].getNota() == nota) {
                return filmes[mid];
            }
            if (filmes[mid].getNota() < nota) {
                return buscaBinariaRecursiva(filmes, nota, mid + 1, right);
            } else {
                return buscaBinariaRecursiva(filmes, nota, left, mid - 1);
            }
        }
        return null;
    }
}

