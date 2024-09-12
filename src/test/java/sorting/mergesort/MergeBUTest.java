package sorting.mergesort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static sorting.mergesort.MergeTestUtils.isSorted;
import static stdLib.StdIn.readFileFromResources;

class MergeBUTest {
    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(
                        (Object) readFileFromResources("src/main/java/sorting/mergesort/words3.txt")
                ),
                Arguments.of(
                        (Object) readFileFromResources("src/main/java/sorting/mergesort/tiny.txt")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void testMergeSort(String[] data) {
        MergeBU.sort(data);
        assertTrue(isSorted(data, 0, data.length - 1));
    }

}