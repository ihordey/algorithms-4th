package practice.week_1.undirected_graph;

import org.junit.Test;
import practice.week_1.GraphUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BreadthFirstSearchTest {

    @Test
    public void isConnected() {
        final BreadthFirstSearch bfs = new BreadthFirstSearch(GraphUtils.tinyGraph(), 0);
        assertThat(bfs.marked(4), is(true));
        assertThat(bfs.marked(3), is(true));
        assertThat(bfs.marked(2), is(true));
        assertThat(bfs.marked(7), is(false));
        assertThat(bfs.marked(9), is(false));
    }

}