package practice.graphs.undirected_graph;

import org.junit.Test;
import practice.graphs.GraphsFilePath;
import stdLib.In;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;

public class DepthFirstPathTest {

    @Test
    public void findPath() {
        final DepthFirstPath dfp = new DepthFirstPath(new Graph(new In(GraphsFilePath.TINY_G)), 0);
        assertThat(dfp.path(3), contains(3, 4, 5, 0));
        assertThat(dfp.path(2), contains(2, 0));
        assertThat(dfp.path(7), empty());
    }
}