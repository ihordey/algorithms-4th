package practice.week_1.union_find;

import org.junit.Assert;
import org.junit.Test;
import practice.common.FilesTest;
import practice.week_1.union_find.QUW;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static practice.common.FilesTest.convertToPairs;

public class QUWTest {

    public static final String PATH_TO_TINY_UF_TXT = "/week_1/tinyUF.txt";
    public static final String PATH_TO_MEDIUM_UF_TXT = "/week_1/mediumUF.txt";
    public static final String PATH_TO_LARGE_UF_TXT = "/week_1/largeUF.txt";

    @Test
    public void haveToBeUnion() throws Exception {
        Path path = Paths.get(getClass().getResource(PATH_TO_TINY_UF_TXT).toURI());
        List<String> lines = FilesTest.readFile(path);

        List<Integer[]> points = convertToPairs(lines);
        Assert.assertEquals(11, points.size());

        QUW qf = new QUW(Integer.parseInt(lines.get(0)));
        points.forEach(p -> {
            qf.union(p[0], p[1]);
//            System.out.println(p[0] + " " + p[1]);
            assertTrue(qf.isConnected(p[0], p[1]));
        });
    }
}