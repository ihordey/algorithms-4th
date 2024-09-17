package graphs.undirectedGraphs;

import org.junit.jupiter.api.Test;
import stdLib.StdOut;
import utils.GraphTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class CycleTest {

    @Test
    void test() {
        final var graph = new Graph(30, 30);
        StdOut.println(graph);

        Cycle finder = new Cycle(graph);
        if (finder.hasCycle()) {
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
        else {
            StdOut.println("Graph is acyclic");
        }
    }
}