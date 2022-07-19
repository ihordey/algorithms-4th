package strings.substringSearch.bruteForce;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import strings.substringSearch.bruteForce.BruteForceSearcher;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BruteForceSearcherTest {
    private final BruteForceSearcher service = new BruteForceSearcher();

    @ParameterizedTest
    @MethodSource("getData")
    void bruteForceTest(String pat, String txt, int expectedResult) {
        assertThat(service.search(pat, txt)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.of("abcde", "we", -1),
                Arguments.of("ABRA", "ABACADABRAC", 6),
                Arguments.of("BRAC", "ABACADABRAC", 7)
        );
    }
}