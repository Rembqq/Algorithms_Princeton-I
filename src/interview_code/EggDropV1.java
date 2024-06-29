package interview_code;

public class EggDropV1 {
    public static int findT(int n) {
        int low = 1;
        int high = n;
        int T = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBroken(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
                T = mid;
            }
        }
        return T;
    }

    private static boolean isBroken(int floor) {
        int T = 10; // пример фиксированного значения T
        return floor >= T;
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println("Максимальный безопасный этаж: " + findT(n));
    }
}

