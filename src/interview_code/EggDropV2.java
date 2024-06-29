package interview_code;

public class EggDropV2 {
    public static int findT(int n) {
        int eggs = (int) (Math.log(n) / Math.log(2));
        int tosses = 2 * eggs;
        return findTUtil(n, eggs, tosses);
    }

    private static int findTUtil(int n, int eggs, int tosses) {
        if (n == 0 || tosses == 0) return 0;
        if (eggs == 1) return linearSearch(n);

        int low = 1, high = n, result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBroken(mid)) {
                result = mid;
                high = mid - 1;
                eggs--;
            } else {
                low = mid + 1;
            }
            tosses--;
        }
        return result - 1;
    }

    private static int linearSearch(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBroken(i)) {
                return i - 1;
            }
        }
        return n;
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

