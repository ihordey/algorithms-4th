package practice.week_1.undirected_graph;

import org.junit.Test;
import stdLib.In;

import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class GraphTest {


    @Test
    public void readGraph() {
        final String tinyGPath = "src/test/resources/week_1/undirected_graph/tinyG.txt";
        final Graph graph = new Graph(new In(Paths.get(tinyGPath).toFile()));
        final DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        assertTrue(dfs.marked(6));
    }
}