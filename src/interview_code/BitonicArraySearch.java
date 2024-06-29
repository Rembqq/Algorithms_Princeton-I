package interview_code;

public class BitonicArraySearch {

    // Метод для нахождения пика
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

    // Метод для бинарного поиска в возрастающем порядке
    public static int binarySearchAscending(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Метод для бинарного поиска в убывающем порядке
    public static int binarySearchDescending(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // Основной метод для поиска элемента в битоническом массиве
    public static int bitonicSearch(int[] arr, int key) {
        int n = arr.length;
        int peak = findPeak(arr, 0, n - 1);

        // Попытка найти элемент в возрастающей части
        int index = binarySearchAscending(arr, 0, peak, key);
        if (index != -1) {
            return index;
        }

        // Попытка найти элемент в убывающей части
        return binarySearchDescending(arr, peak + 1, n - 1, key);
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

