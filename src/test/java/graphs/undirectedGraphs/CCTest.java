package graphs.undirectedGraphs;

import fundamentals.bagsQueuesStacks.Queue;
import org.junit.jupiter.api.Test;
import stdLib.StdOut;
import utils.GraphTestUtils;

class CCTest {


    @Test
    void testCC() {
        final var graph = GraphTestUtils.getGraph("./src/test/resources/tinyG.txt");
        CC cc = new CC(graph);

        // number of connected components
        int M = cc.count();
        StdOut.println(M + " components");

        // compute list of vertices in each connected component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < graph.v(); v++) {
            components[cc.id(v)].enqueue(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
}