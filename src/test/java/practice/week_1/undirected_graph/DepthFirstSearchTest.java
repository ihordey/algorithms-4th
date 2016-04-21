package practice.week_1.undirected_graph;

import org.junit.Test;
import practice.week_1.GraphUtils;

import static org.junit.Assert.assertTrue;

public class DepthFirstSearchTest {


    @Test
    public void readGraph() {
        final DepthFirstSearch dfs = new DepthFirstSearch(GraphUtils.tinyGraph(), 0);
        assertTrue(dfs.marked(6));
    }
}