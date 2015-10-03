package practice.week_1;

import org.junit.Assert;
import org.junit.Test;
import practice.common.FilesTest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

public class QUTest {
    
    public static final String PATH_TO_TINY_UF_TXT = "/week_1/tinyUF.txt";
    public static final String PATH_TO_MEDIUM_UF_TXT = "/week_1/mediumUF.txt";
    public static final String PATH_TO_LARGE_UF_TXT = "/week_1/largeUF.txt";

    @Test
    public void testUnion() throws Exception {
        //TODO implement as common
        Path path = Paths.get(getClass().getResource(PATH_TO_TINY_UF_TXT).toURI());
        List<String> lines = FilesTest.readFile(path);

        List<Integer[]> points = lines.stream().
                map(i -> i.split(" ")).
                filter(i -> i.length == 2).
                map(i -> new Integer[]{Integer.valueOf(i[0]), Integer.valueOf(i[1])}).
                collect(toList());
        Assert.assertEquals(11, points.size());

        QU qu = new QU(Integer.parseInt(lines.get(0)));
        points.forEach(p -> {
            qu.union(p[0], p[1]);
            System.out.println(p[0] + " " + p[1]);
            assertTrue(qu.isConnected(p[0], p[1]));
        });
    }
}