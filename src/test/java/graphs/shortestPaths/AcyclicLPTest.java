package graphs.shortestPaths;

import org.junit.jupiter.api.Test;
import stdLib.In;
import stdLib.StdOut;

import java.io.File;

class AcyclicLPTest {

    @Test
    void test() {
        In in = new In(new File("./src/test/resources/tinyEWDAG.txt"));
        int s = 5;
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(in);
        AcyclicLP lp = new AcyclicLP(graph, s);

        for (int v = 0; v < graph.v(); v++) {
            if (lp.hasPathTo(v)) {
                StdOut.printf("%d to %d (%.2f)  ", s, v, lp.distTo(v));
                for (DirectedEdge e : lp.pathTo(v)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d         no path\n", s, v);
            }
        }
    }
}