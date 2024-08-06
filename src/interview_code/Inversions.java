package interview_code;

public class Inversions {
    private int countInversions(Comparable[] a, int lo, int hi) {

        if(lo >= hi) {
            return 0;
        }

        int count = 0;
        int mid = lo + (hi - lo) / 2;
        count += countInversions(a, lo, mid);
        count += countInversions(a, mid + 1, hi);
        count += mergeCount(a, lo, mid, hi);

        return count;
    }
    private int mergeCount(Comparable[] a, int lo, int mid, int hi) {
        Comparable[] left = new Comparable[mid - lo + 1];
        Comparable[] right = new Comparable[hi - mid];

        for(int i = 0; i < left.length; ++i) {
            left[i] = a[lo + i];
        }
        for(int i = 0; i < right.length; ++i) {
            right[i] = a[mid + 1 + i];
        }

        int i = 0, j = 0, k = lo, inversions = 0;

        while(i < left.length && j < right.length) {
            if(left[i].compareTo(right[j]) <= 0) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
                inversions += (mid + 1) - (lo + i);
                // if left[i] > right[j], then all elems in left
                // array after left[i] are bigger than right[j]
            }
        }

        while(i < left.length) {
            a[k++] = left[i++];
        }
        while(j < right.length) {
            a[k++] = right[j++];
        }
        return inversions;
    }

    public int countInversions(Comparable[] a) {
        if(a == null || a.length < 2) {
            return 0;
        }
        return countInversions(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 9, 3, 8, 2, 1, 7};
        Inversions inv = new Inversions();
        System.out.println(inv.countInversions(arr));

    }
}
