package practice.graphs.undirected_graph;

import org.junit.Test;
import practice.graphs.GraphsFilePath;
import stdLib.In;

import static org.junit.Assert.assertTrue;

public class DepthFirstSearchTest {

    @Test
    public void readGraph() {
        final DepthFirstSearch dfs = new DepthFirstSearch(new Graph(new In(GraphsFilePath.TINY_G)), 0);
        assertTrue(dfs.marked(6));
    }
}