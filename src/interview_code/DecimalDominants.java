package interview_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecimalDominants {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 2, 1, 2, 3, 1, 4, 5, 1, 6, 1, 1, 7, 8, 1, 9, 1, 10};
        List<Integer> result = findDecimalDominants(array);
        System.out.println("Elements that appear more than n/10 times: " + result);
    }

    public static List<Integer> findDecimalDominants(int[] array) {
        int n = array.length;
        // Map для хранения до 9 кандидатов и их счетчиков
        Map<Integer, Integer> candidates = new HashMap<>();

        // Шаг 1: Поиск кандидатов
        for (int num : array) {
            if (candidates.containsKey(num)) {
                candidates.put(num, candidates.get(num) + 1);
            } else if (candidates.size() < 9) {
                candidates.put(num, 1);
            } else {
                // Уменьшаем счетчики у всех кандидатов
                List<Integer> toRemove = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : candidates.entrySet()) {
                    candidates.put(entry.getKey(), entry.getValue() - 1);
                    if (candidates.get(entry.getKey()) == 0) {
                        toRemove.add(entry.getKey());
                    }
                }
                // Удаляем кандидатов с нулевым счетчиком
                for (Integer key : toRemove) {
                    candidates.remove(key);
                }
            }
        }

        // Шаг 2: Проверка кандидатов
        Map<Integer, Integer> actualCount = new HashMap<>();
        for (int num : array) {
            if (candidates.containsKey(num)) {
                actualCount.put(num, actualCount.getOrDefault(num, 0) + 1);
            }
        }

        // Собираем результаты
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : actualCount.entrySet()) {
            if (entry.getValue() > n / 10) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
