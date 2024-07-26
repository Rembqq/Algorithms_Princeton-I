package interview_code;

import java.util.Arrays;

public class DutchFlag {
    public static void dutchSort(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        // low - first border
        // mid - current elem
        // high last border


        for( ; mid <= high ; ) {
            int currColor = color(mid, arr);

            if(currColor == 0) {
                swap(low, mid, arr);
                low++;
                mid++;
            }
            else if(currColor == 1) {
                // swap(mid, mid);
                mid++;
            } else if(currColor == 2) {
                swap(high, mid, arr);
                high--;
            } else {
                throw new IllegalArgumentException("Array should contain only (0, 1, 2) representing: red, white, blue");
            }
        }

    }
    private static int color(int i, int[] arr) {
        return arr[i];
    }
    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 0, 0, 2, 1, 2, 1, 0};
        dutchSort(arr1);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}
