package interview_code;

import java.util.Arrays;

public class MergesortWithSmallerAux {
    public static void merge(Comparable[] a, int n) {
        Comparable[] aux = new Comparable[n];

        // Step 1: Copy the first half into the auxiliary array
        for (int i = 0; i < n; i++) {
            aux[i] = a[i];
        }

        // Step 2: Merge the two subarrays back into the original array
        int i = 0, j = n, k = 0;
        while (i < n && j < 2 * n) {
            if (less(aux[i], a[j])) {
                a[k++] = aux[i++];
            } else {
                a[k++] = a[j++];
            }
        }

        // Copy any remaining elements from the auxiliary array
        while (i < n) {
            a[k++] = aux[i++];
        }

        // Copy any remaining elements from the second subarray (though usually not needed)
        while (j < 2 * n) {
            a[k++] = a[j++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        // Example usage
        Integer[] a = {1, 3, 5, 7, 2, 4, 6, 8};
        int n = a.length / 2;
        merge(a, n);
        System.out.println(Arrays.toString(a));  // Output: [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
