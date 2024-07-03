import java.util.Collection;
import java.util.Iterator;

public class Deque<Item> /*implements Iterable<Item>*/ {

    private Node first;
    private Node last;
    private int size;
    private class Node {
        Item item;
        Node next;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }


    // return the number of items on the deque
    public int size() {
//        int size = 1;
//        if(!isEmpty())
//        {
//            for(Node i = first; i != last; i = i.next)
//            {
//                size++;
//            }
//        }
        return size;
    }

    private void nulArgCheck(Item item) {
        if(item == null) {
            throw new IllegalArgumentException("null is prohibited!");
        }
    }
    private void emptyDequeCheck() {
        if(isEmpty()) {
            throw new java.util.NoSuchElementException("Deque is empty!");
        }
    }

    // add the item to the front
    public void addFirst(Item item) {
        nulArgCheck(item);
        
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        
        if(last == null) {
            last = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        nulArgCheck(item);
        
        Node oldLast = last;
        last = new Node();
        oldLast.next = last;
        last.item = item;
        
        if(first == null) {
            first = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        emptyDequeCheck();
        Item data = first.item;
        first = first.next;
        size--;
        return data;
    }

    // remove and return the item from the back
    public Item removeLast() {
        emptyDequeCheck();
        // linear search
        if(size == 1) {
            Item data1 = first.item;
            first = null;
            return data1;
        }
        Node penultimate = first;
        while(penultimate.next != last) {
            penultimate = penultimate.next;
        }
        Item data = last.item;
        penultimate.next = null;
        size--;
        return data;
    }

    // return an iterator over items in order from front to back
    // public Iterator<Item> iterator() {

    // }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        String[] data = {"data1", "data2", "data3", "data4", "data5", "data6"};
        deque.addFirst(data[0]);
        deque.addLast(data[2]);
        System.out.println(deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.size());
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        System.out.println(deque.removeLast());
    }
}












