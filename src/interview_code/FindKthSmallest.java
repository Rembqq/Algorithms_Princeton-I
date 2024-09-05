package interview_code;

public class FindKthSmallest {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = {2, 4, 6, 8, 10};
        int k = (a.length + b.length) / 2;  // Ищем медиану

        int result = findKthSmallest(a, b, k);
        System.out.println("Элемент с рангом " + k + ": " + result);
    }

    // Основная функция для поиска k-го по порядку элемента
    public static int findKthSmallest(int[] a, int[] b, int k) {
        return kthSmallest(a, 0, a.length, b, 0, b.length, k);
    }

    // Рекурсивная функция для поиска k-го элемента
    private static int kthSmallest(int[] a, int aStart, int aLength,
                                   int[] b, int bStart, int bLength, int k) {
        // Если массив `a` пуст, просто возвращаем элемент из массива `b`
        if (aLength == 0) {
            return b[bStart + k];
        }

        // Если массив `b` пуст, просто возвращаем элемент из массива `a`
        if (bLength == 0) {
            return a[aStart + k];
        }

        // Если k = 0, просто возвращаем минимальный элемент из первых элементов массивов
        if (k == 0) {
            return Math.min(a[aStart], b[bStart]);
        }

        // Разделяем `k` между массивами
        int i = Math.min(aLength, (k + 1) / 2) - 1;
        int j = Math.min(bLength, (k + 1) / 2) - 1;

        if (a[aStart + i] > b[bStart + j]) {
            // Элемент из массива `b` меньше, исключаем его и уменьшаем k
            return kthSmallest(a, aStart, aLength, b, bStart + j + 1, bLength - (j + 1), k - (j + 1));
        } else {
            // Элемент из массива `a` меньше, исключаем его и уменьшаем k
            return kthSmallest(a, aStart + i + 1, aLength - (i + 1), b, bStart, bLength, k - (i + 1));
        }
    }
}

