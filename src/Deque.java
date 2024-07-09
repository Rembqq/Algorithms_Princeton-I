import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;
    private static class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }


    // return the number of items on the deque
    public int size() {
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

        Node<Item> oldFirst = first;
        first = new Node<>();
        first.next = oldFirst;
        first.item = item;
        first.prev = null;

        if(isEmpty()) {
            last = first;
        } else {
            // first.next.prev = first
            oldFirst.prev = first;
        }

        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        nulArgCheck(item);

        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        last.prev = oldLast;

        if(isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        emptyDequeCheck();

        Item data = first.item;
        first = first.next;
        size--;
        if(isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }
        return data;
    }

    // remove and return the item from the back
    public Item removeLast() {
        emptyDequeCheck();
        // linear search
//        if(size == 1) {
//            Item data1 = first.item;
//            first = last = null;
//            size--;
//            return data1;
//        }
//        Node penultimate = first;
//        while(penultimate.next != last) {
//            penultimate = penultimate.next;
//        }
//        Item data = last.item;
//        last = penultimate;
//        last.next = null;
//        size--;
//        return data;
        Item data = last.item;
        last = last.prev;
        size--;

        if(isEmpty()) {
            first = null;
        } else {
            last.next = null;
        }

        return data;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator(first);
    }


    private class DequeIterator implements Iterator<Item> {
        private Node<Item> current;

        public DequeIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        String[] data = {"data1", "data2", "data3", "data4", "data5", "data6"};
        deque.addFirst(data[0]);
        deque.addLast(data[2]);
        System.out.println(deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.size());
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        for(String s : deque) {
            System.out.println(s);
        }
        //System.out.println(deque.removeLast());
    }
}