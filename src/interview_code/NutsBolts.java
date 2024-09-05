package interview_code;

import java.util.Arrays;

public class NutsBolts {

    public static void main(String[] args) {
        char[] nuts = {'@', '#', '$', '%', '^', '&'};
        char[] bolts = {'$', '%', '&', '^', '@', '#'};

        matchPairs(nuts, bolts, 0, nuts.length - 1);

        System.out.println("Matched nuts and bolts are: ");
        System.out.println("Nuts:   " + Arrays.toString(nuts));
        System.out.println("Bolts:  " + Arrays.toString(bolts));
    }

    // Function to perform the matching of nuts and bolts
    public static void matchPairs(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            // Choose the last bolt as the pivot for nuts partition
            int pivotIndex = partition(nuts, low, high, bolts[high]);

            // Now using the nut as the pivot for bolts partition
            partition(bolts, low, high, nuts[pivotIndex]);

            // Recursively match pairs in the left and right subarrays
            matchPairs(nuts, bolts, low, pivotIndex - 1);
            matchPairs(nuts, bolts, pivotIndex + 1, high);
        }
    }

    // Partition function similar to quicksort's
    private static int partition(char[] array, int low, int high, char pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            } else if (array[j] == pivot) {
                swap(array, j, high);
                j--;
            }
        }
        swap(array, i, high);
        return i;
    }

    // Helper function to swap elements
    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

