import java.util.Collection;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

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

    // add the item to the front
    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node();
        oldLast.next = last;
        last.item = item;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Item data = first.item;
        first = first.next;
        size--;
        return data;
    }

    // remove and return the item from the back
    public Item removeLast() {
        // linear search
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
    public Iterator<Item> iterator() {

    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}













