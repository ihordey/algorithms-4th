package practice.graphs.undirected_graph;

import org.junit.Test;
import practice.graphs.GraphsFilePath;
import stdLib.In;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BreadthFirstSearchTest {

    @Test
    public void isConnected() {
        BreadthFirstSearch bfs = new BreadthFirstSearch(new Graph(new In(GraphsFilePath.TINY_G)), 0);
        assertThat(bfs.marked(4), is(true));
        assertThat(bfs.marked(3), is(true));
        assertThat(bfs.marked(2), is(true));
        assertThat(bfs.marked(7), is(false));
        assertThat(bfs.marked(9), is(false));
    }

}