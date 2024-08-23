package sorting.mergesort;

import static sorting.mergesort.MergeUtils.less;

public final class MergeTestUtils {
    private MergeTestUtils() {
    }

    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
