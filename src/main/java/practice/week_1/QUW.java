package practice.week_1;


import java.util.stream.Stream;

public class QUW implements DynamicConnectivity<Integer> {
    private final int size;
    private Integer[] source;
    private Integer[] weight;

    public QUW(int size) {
        this.size = size;
        this.source = initSource(size, 0, i -> i + 1).toArray(new Integer[]{});
        this.weight = Stream.generate(() -> 1).limit(size).toArray(s -> new Integer[s]);
    }

    @Override
    public void union(Integer from, Integer to) {
        if (isConnected(from, to)) return;
        Integer fromVal = find(from);
        Integer toVal = find(to);
        if (weight[fromVal] > weight[to]) {
            source[toVal] = source[fromVal];
            weight[fromVal] += weight[toVal];
        } else {
            source[fromVal] = source[toVal];
            weight[toVal] += weight[fromVal];
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
    public Integer find(Integer val) {
        while (source[val] != val) {
            val = source[val];
        }
        return val;
    }
}
