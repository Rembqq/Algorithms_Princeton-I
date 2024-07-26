package interview_code;

import edu.princeton.cs.algs4.StdRandom;

public class EntriesOrderPermutation {
    public static boolean isPermutation(int[] a, int[] b) {
        // Если длины массивов разные, они не могут быть пермутациями друг друга
        if (a.length != b.length) {
            return false;
        }

        // Копируем массивы, чтобы не изменять исходные
        int[] sortedA = copyArray(a);
        int[] sortedB = copyArray(b);

        // Сортируем оба массива
        sort(sortedA);
        sort(sortedB);

        // Сравниваем отсортированные массивы
        return equals(sortedA, sortedB);
    }

    private static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    private static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static boolean equals(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] b = {1, 3, 5, 5, 3, 1, 4, 2, 5, 9, 6};

        boolean result = isPermutation(a, b);
        System.out.println("Are the arrays permutations of each other? " + result);
    }
}
