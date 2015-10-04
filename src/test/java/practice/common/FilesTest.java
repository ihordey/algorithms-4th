package practice.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public interface FilesTest {

    static List<String> readFile(Path path) throws IOException {
        if (!Files.exists(path)) {
            return Collections.emptyList();
        }
        return Files.readAllLines(path);
    }

    static List<Integer[]> convertToPairs(List<String> lines) {
        return lines.stream().
                map(i -> i.split(" ")).
                filter(i -> i.length == 2).
                map(i -> new Integer[]{Integer.valueOf(i[0]), Integer.valueOf(i[1])}).
                collect(toList());
    }
}
