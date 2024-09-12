package graphs.undirectedGraphs;

import org.junit.jupiter.api.Test;
import stdLib.In;
import stdLib.StdOut;

import java.io.File;

class DepthFirstSearchTest {
    @Test
    void testDepthFirstSearch() {
        In in = new In(new File("./src/test/resources/tinyG.txt"));
        Graph G = new Graph(in);
        int s = 12;
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        System.out.println("connected to vertex " + s);
        for (int v = 0; v < G.v(); v++) {
            if (search.marked(v) && v != s)
                StdOut.print(v + " ");
        }
    }
}