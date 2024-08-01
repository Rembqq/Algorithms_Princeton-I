package interview_code;

public class Mergesort {
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for(int k = lo; k <= hi; ++k) {
            aux[k] = a[k];
        }
        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; ++k) {
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux, j, i)) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable[] aux, int i, int j) {
        return aux[i].compareTo(aux[j]) < 0;
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if(lo >= hi) {
            return;
        }
        int mid = lo + ((hi-lo) / 2);

        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void main(String[] args) {

        Integer[] a = { 38, 27, 43, 3, 9, 82, 10 };

        System.out.println("Before sorting:");
        for (int num : a) {
            System.out.print(num + " ");
        }

        Mergesort.sort(a);

        System.out.println("\nAfter sorting:");
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}

