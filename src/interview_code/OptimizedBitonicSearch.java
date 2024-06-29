package interview_code;

public class OptimizedBitonicSearch {

    public static int findPeak(int[] arr, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
                return mid;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int low, int high, int key, boolean ascending) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (ascending) {
                if (arr[mid] < key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (arr[mid] < key) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int bitonicSearch(int[] arr, int key) {
        int n = arr.length;
        int peak = findPeak(arr, 0, n - 1);

        // Проверка, если ключ равен пиковому элементу
        if (arr[peak] == key) {
            return peak;
        }

        // Попытка найти элемент в возрастающей части
        int index = binarySearch(arr, 0, peak - 1, key, true);
        if (index != -1) {
            return index;
        }

        // Попытка найти элемент в убывающей части
        return binarySearch(arr, peak + 1, n - 1, key, false);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int key = 4;
        int index = bitonicSearch(arr, key);
        if (index != -1) {
            System.out.println("Элемент найден на позиции: " + index);
        } else {
            System.out.println("Элемент не найден");
        }
    }
}

