package graphs.directedGraphs;

import org.junit.jupiter.api.Test;
import stdLib.In;
import stdLib.StdOut;

import java.io.File;

class DirectedCycleTest {

    @Test
    void test() {
//        In in = new In(new File("./src/test/resources/tinyDG.txt"));
        In in = new In(new File("./src/test/resources/tinyDAG.txt"));
        Digraph graph = new Digraph(in);
        DirectedCycle finder = new DirectedCycle(graph);
        if (finder.hasCycle()) {
            StdOut.print("Cycle: ");
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        } else {
            StdOut.println("No cycle");
        }
    }

    private boolean check(DirectedCycle cycle) {
        if (cycle.hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle.cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }
}