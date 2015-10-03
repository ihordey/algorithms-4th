package practice.week_1;

import java.util.stream.Stream;

/**
 * Quick Find Algorithm
 */

public class QF implements DynamicConnectivity<Integer> {

    private int size;
    private Integer[] source;

    public QF(int size) {
        this.size = size;
        source = Stream.iterate(0, i -> i + 1).
                limit(size).
                toArray(s -> new Integer[s]);

    }

    @Override
    public void union(Integer from, Integer to) {
        if (isConnected(from, to)) return;
        Integer toVal = find(to);
        Integer fromVal = find(from);
        for (int i = 0; i < source.length; i++) {
            if (toVal.equals(find(i))) {
                source[i] = fromVal;
            }
        }
    }

    @Override
    public boolean isConnected(Integer from, Integer to) {
        return find(from).equals(find(to));
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Integer find(Integer id) {
        return source[id];
    }
}
