package atividade01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ordenacao {

    public static void bubbleSort(Filme[] filmes) {
        int n = filmes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (filmes[j].compareTo(filmes[j + 1]) > 0) {
                    Filme temp = filmes[j];
                    filmes[j] = filmes[j + 1];
                    filmes[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(Filme[] filmes) {
        if (filmes.length > 1) {
            int mid = filmes.length / 2;
            Filme[] left = Arrays.copyOfRange(filmes, 0, mid);
            Filme[] right = Arrays.copyOfRange(filmes, mid, filmes.length);

            mergeSort(left);
            mergeSort(right);

            merge(filmes, left, right);
        }
    }

    private static void merge(Filme[] filmes, Filme[] left, Filme[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                filmes[k++] = left[i++];
            } else {
                filmes[k++] = right[j++];
            }
        }
        while (i < left.length) {
            filmes[k++] = left[i++];
        }
        while (j < right.length) {
            filmes[k++] = right[j++];
        }
    }

    public static void quickSort(Filme[] filmes) {
        quickSort(filmes, 0, filmes.length - 1);
    }

    private static void quickSort(Filme[] filmes, int low, int high) {
        if (low < high) {
            int pi = partition(filmes, low, high);
            quickSort(filmes, low, pi - 1);
            quickSort(filmes, pi + 1, high);
        }
    }

    private static int partition(Filme[] filmes, int low, int high) {
        Filme pivot = filmes[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (filmes[j].compareTo(pivot) <= 0) {
                i++;
                Filme temp = filmes[i];
                filmes[i] = filmes[j];
                filmes[j] = temp;
            }
        }
        Filme temp = filmes[i + 1];
        filmes[i + 1] = filmes[high];
        filmes[high] = temp;
        return i + 1;
    }

    public static void quickSortShuffle(Filme[] filmes) {
        List<Filme> list = Arrays.asList(filmes);
        Collections.shuffle(list);
        list.toArray(filmes);
        quickSort(filmes);
    }

    public static void countingSort(Filme[] filmes) {
        int max = 5; // Nota máxima é 5
        int min = 1; // Nota mínima é 1
        int range = max - min + 1;

        int[] count = new int[range];
        Filme[] output = new Filme[filmes.length];

        for (Filme filme : filmes) {
            count[filme.getNota() - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = filmes.length - 1; i >= 0; i--) {
            output[count[filmes[i].getNota() - min] - 1] = filmes[i];
            count[filmes[i].getNota() - min]--;
        }

        System.arraycopy(output, 0, filmes, 0, filmes.length);
    }
}