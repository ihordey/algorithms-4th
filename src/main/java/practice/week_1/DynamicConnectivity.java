package practice.week_1;


public interface DynamicConnectivity<Integer> {

    void union(Integer from, Integer to);

    boolean isConnected(Integer from, Integer to);

    int count();

    Integer find(Integer val);
}
