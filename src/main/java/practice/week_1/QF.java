package practice.week_1;

/**
 * Quick Find Algorithm
 */

public class QF implements DynamicConnectivity<Integer> {

    private final int size;
    private Integer[] source;

    public QF(int size) {
        this.size = size;
        source = initSource(size, 0, i -> i + 1).toArray(new Integer[]{});
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
