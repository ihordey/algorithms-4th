package practice.union_find;

import org.junit.Assert;
import org.junit.Test;
import practice.common.FilesTest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static practice.common.FilesTest.convertToPairs;

public class QUTest {
    
    public static final String PATH_TO_TINY_UF_TXT = "/union_find/tinyUF.txt";
    public static final String PATH_TO_MEDIUM_UF_TXT = "/union_find/mediumUF.txt";
    public static final String PATH_TO_LARGE_UF_TXT = "/union_find/largeUF.txt";

    @Test
    public void testUnion() throws Exception {
        Path path = Paths.get(getClass().getResource(PATH_TO_TINY_UF_TXT).toURI());
        List<String> lines = FilesTest.readFile(path);

        List<Integer[]> points = convertToPairs(lines);
        Assert.assertEquals(11, points.size());

        QU qu = new QU(Integer.parseInt(lines.get(0)));
        points.forEach(p -> {
            qu.union(p[0], p[1]);
//            System.out.println(p[0] + " " + p[1]);
            assertTrue(qu.isConnected(p[0], p[1]));
        });
    }

}