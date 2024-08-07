package interview_code;

import java.util.Random;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class LinkedListShuffle {

    private static Random random = new Random();

    public static Node shuffle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Разделить список на две части
        Node[] split = splitList(head);
        Node first = split[0];
        Node second = split[1];

        // Рекурсивно перемешать обе части
        first = shuffle(first);
        second = shuffle(second);

        // Слить обе части обратно
        return merge(first, second);
    }

    private static Node[] splitList(Node head) {
        if (head == null || head.next == null) {
            return new Node[]{head, null};
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return new Node[]{head, slow};
    }

    private static Node merge(Node first, Node second) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (first != null && second != null) {
            if (random.nextBoolean()) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        if (first != null) {
            current.next = first;
        } else {
            current.next = second;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = shuffle(head);

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}



