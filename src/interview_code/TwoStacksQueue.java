package interview_code;

import java.util.Stack;

public class TwoStacksQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;
    public TwoStacksQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void enqueue(T data) {
        stack1.push(data);
    }
    public T dequeue() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack2.pop();
    }
    public static void main(String[] args) {
        TwoStacksQueue<Integer> queue = new TwoStacksQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
