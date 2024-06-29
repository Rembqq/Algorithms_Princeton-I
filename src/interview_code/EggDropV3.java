package interview_code;

public class EggDropV3 {
    public static int findT(int n) {
        int interval = (int) Math.ceil((Math.sqrt(1 + 8 * n) - 1) / 2);
        int previous = 0;
        int current = interval;

        while (current <= n && !isBroken(current)) {
            previous = current;
            interval--;
            current += interval;
        }

        for (int i = previous + 1; i < current; i++) {
            if (isBroken(i)) {
                return i - 1;
            }
        }
        return current - 1;
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

