package interview_code;

public class EggDropV0 {
    public static int findT(int n) {
        int T = 0;
        for (int i = 1; i <= n; i++) {
            T++;
            if (isBroken(i)) { // Предположим, что isBroken(i) возвращает true, если яйцо разбивается
                return T - 1;
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

