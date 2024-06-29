package interview_code;
import java.util.Arrays;

public class Three_Sum_Quadratic {
    public static void findThreeSum(int[] arr) {
        Arrays.sort(arr);  // Сортируем массив

        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            // Для текущего элемента arr[i] используем два указателя
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    System.out.println("Тройка найдена: " + arr[i] + ", " + arr[left] + ", " + arr[right]);
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        findThreeSum(arr);
    }
}
