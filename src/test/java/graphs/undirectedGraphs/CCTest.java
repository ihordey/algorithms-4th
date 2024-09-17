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

        int count = cc.count();
        StdOut.println(count + " components");

        var components = (Queue<Integer>[]) new Queue[count];
        for (int i = 0; i < count; i++) {
            components[i] = new Queue<>();
        }
        for (int v = 0; v < graph.v(); v++) {
            components[cc.id(v)].enqueue(v);
        }

        // print results
        for (int i = 0; i < count; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
}