package practice.week_1;


import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public interface DynamicConnectivity<T> {

    void union(T from, T to);

    boolean isConnected(T from, T to);

    int count();

    T find(T val);

    default List<T> initSource(int size, T seed, UnaryOperator<T> operator) {
        return  Stream.iterate(seed, operator).
                limit(size).
                collect(toList());
    }
}
