package practice.week_1;

import org.junit.Assert;
import org.junit.Test;
import practice.common.FilesTest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

public class QFTest {

    public static final String PATH_TO_TINY_UF_TXT = "/week_1/tinyUF.txt";

    @Test
    public void haveToBeUnion() throws Exception {
        Path path = Paths.get(getClass().getResource(PATH_TO_TINY_UF_TXT).toURI());
        List<String> lines = FilesTest.readFile(path);

        List<Integer[]> points = lines.stream().
                map(i -> i.split(" ")).
                filter(i -> i.length == 2).
                map(i -> new Integer[]{Integer.valueOf(i[0]), Integer.valueOf(i[1])}).
                collect(toList());
        Assert.assertEquals(11, points.size());

        QF qf = new QF(Integer.parseInt(lines.get(0)));
        points.forEach(p -> {
            qf.union(p[0], p[1]);
            System.out.println(p[0] + " " + p[1]);
            assertTrue(qf.isConnected(p[0], p[1]));
        });
    }

    @Test
    public void testIsConnected() {

    }
}