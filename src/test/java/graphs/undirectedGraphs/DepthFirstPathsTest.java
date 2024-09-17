package graphs.undirectedGraphs;

import org.junit.jupiter.api.Test;
import stdLib.In;
import stdLib.StdOut;

import java.io.File;

class DepthFirstPathsTest {

    @Test
    void test() {
        In in = new In(new File("./src/test/resources/tinyCG.txt"));
        Graph graph = new Graph(in);
        int s = 2;
        DepthFirstPaths dfs = new DepthFirstPaths(graph, s);

        for (int v = 0; v < graph.v(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }
        }
    }
}