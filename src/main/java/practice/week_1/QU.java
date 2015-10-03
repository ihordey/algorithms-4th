package practice.week_1;


public class QU implements DynamicConnectivity<Integer> {

    private final int size;
    private final Integer[] source;

    public QU(int size) {
        this.size = size;
        this.source = initSource(size, 0, i -> i + 1).toArray(new Integer[]{});
    }

    @Override
    public void union(Integer from, Integer to) {
        if (isConnected(from, to)) return;
        Integer fromVal = find(from);
        Integer toVal = find(to);

        source[toVal] = fromVal;
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
    public Integer find(Integer val) {
        while (!source[val].equals(val)) {
            val = source[val];
        }
        return val;
    }
}
