import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private StdRandom random;
    private int size;

    public RandomizedQueue() {
        queue = (Item[]) new Object[2];
        size = 0;
    }

    private void resize(int newLength) {
        Item[] copy = (Item[]) new Object[newLength];
        for(int i = 0; i < size; ++i) {
            copy[i] = queue[i];
        }
        queue = copy;
    }

    private void nulArgCheck(Item item) {
        if(item == null) {
            throw new IllegalArgumentException("null is prohibited!");
        }
    }

    private void emptyDequeCheck() {
        if(isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
        }
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        nulArgCheck(item);
        if(queue.length == size) {
            resize( queue.length * 2);
        }

        queue[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        emptyDequeCheck();

        int randIndex = StdRandom.uniform(size);
        Item item = queue[randIndex];

        for(int i = randIndex; i < size - 1; ++i) {
            queue[i] = queue[i+1];
        }
        queue[size - 1] = null;
        size--;

        if(queue.length / 4 == size) {
            resize(queue.length / 2);
        }

        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        emptyDequeCheck();

        int randIndex = StdRandom.uniform(size);
        return queue[randIndex];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int current;
        private int[] indices;

        public RandomizedQueueIterator() {
            current = 0;
            indices = new int[size];
            for(int i = 0; i < size; i++) {
                indices[i] = i;
            }
            StdRandom.shuffle(indices);
        }
        public boolean hasNext() {
            return current < size;
        }
        public Item next() {
            emptyDequeCheck();

            return queue[indices[current++]];
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        String[] data = {"data1", "data2", "data3", "data4", "data5", "data6"};

        queue.enqueue(data[2]);
        queue.enqueue(data[4]);
        queue.enqueue(data[0]);
        System.out.println(queue.size());
        System.out.println(queue.sample());
        for(String s : queue) {
            System.out.print(s + " ");
        }
        System.out.print("\n" + queue.dequeue());
        System.out.println("\n" + queue.sample());
        System.out.println(queue.size());
        for(String s : queue) {
            System.out.print(s + " ");
        }
        System.out.print("\n" + queue.dequeue());
        System.out.println("\n" + queue.sample());
        System.out.println(queue.size());
        for(String s : queue) {
            System.out.println(s);
        }
    }


}