package sorting.mergesort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static sorting.mergesort.MergeTestUtils.isSorted;
import static sorting.mergesort.MergeUtils.less;
import static stdLib.StdIn.readFile;

class MergeTest {
    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(
                        (Object)readFile("src/main/java/sorting/mergesort/words3.txt")
                ),
                Arguments.of(
                        (Object) readFile("src/main/java/sorting/mergesort/tiny.txt")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void testMergeSort(String[] data) {
        Merge.sort(data);
        assertTrue(isSorted(data, 0, data.length - 1));
    }
}