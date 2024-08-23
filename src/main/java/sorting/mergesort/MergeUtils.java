package sorting.mergesort;

import stdLib.StdOut;

public final class MergeUtils {
    private MergeUtils() {
    }

    public static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void merge(Comparable<String>[] a, Comparable<String>[] aux, int lo, int mid, int hi) {
        System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    public static void show(Comparable<String>[] a) {
        for (var integerComparable : a) {
            StdOut.println(integerComparable);
        }
    }

}
