package interview_code;

import java.util.Stack;

public class StackWithMax {
    private Stack<Double> mainStack;
    private Stack<Double> maxStack;

    public MaxStack() {
        mainStack = new Stack<>();
        maxStack = new Stack<>();
    }

    // Добавление элемента в стек
    public void push(double value) {
        mainStack.push(value);
        // Если maxStack пуст или новый элемент больше или равен текущему максимуму
        if (maxStack.isEmpty() || value >= maxStack.peek()) {
            maxStack.push(value);
        }
    }

    // Извлечение элемента из стека
    public double pop() {
        if (mainStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        double value = mainStack.pop();
        // Если извлеченный элемент равен текущему максимуму, также извлекаем его из maxStack
        if (value == maxStack.peek()) {
            maxStack.pop();
        }
        return value;
    }

    // Получение максимального элемента в стеке
    public double getMax() {
        if (maxStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return maxStack.peek();
    }

    // Проверка, пустой ли стек
    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public static void main(String[] args) {
        StackWithMax stack = new StackWithMax();
        stack.push(3.0);
        stack.push(1.5);
        stack.push(2.5);
        stack.push(5.0);
        stack.push(4.0);

        System.out.println("Current Max: " + stack.getMax()); // Выводит 5.0
        System.out.println("Popped: " + stack.pop()); // Выводит 4.0
        System.out.println("Current Max: " + stack.getMax()); // Выводит 5.0
        System.out.println("Popped: " + stack.pop()); // Выводит 5.0
        System.out.println("Current Max: " + stack.getMax()); // Выводит 3.0
    }
}

