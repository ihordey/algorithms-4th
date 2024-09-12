package graphs.undirectedGraphs;

import org.junit.jupiter.api.Test;
import stdLib.StdOut;
import utils.GraphTestUtils;

class BreadthFirstPathsTest {

    @Test
    void test() {
        int s = 3;
        final var graph = GraphTestUtils.getGraph("./src/test/resources/tinyG.txt");
        final var bfs = new BreadthFirstPaths(graph, s);
        /*for (int v = 0; v < graph.V(); v++) {
            if (bfs.hasPathTo(v)) {
                StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d (-):  not connected\n", s, v);
            }
        }*/
        System.out.println("checking...");
        check(graph, s, bfs);
    }


    // check optimality conditions for single source
    private void check(Graph G, int s, BreadthFirstPaths bfs) {
        // check that the distance of s = 0
        if (bfs.distTo[s] != 0) {
            StdOut.println("distance of source " + s + " to itself = " + bfs.distTo[s]);
            return;
        }

        // check that for each edge v-w dist[w] <= dist[v] + 1
        // provided v is reachable from s
        for (int v = 0; v < G.v(); v++) {
            for (int w : G.adj(v)) {
                if (bfs.hasPathTo(v) != bfs.hasPathTo(w)) {
                    StdOut.println("edge " + v + "-" + w);
                    StdOut.println("hasPathTo(" + v + ") = " + bfs.hasPathTo(v));
                    StdOut.println("hasPathTo(" + w + ") = " + bfs.hasPathTo(w));
                    return;
                }
                if (bfs.hasPathTo(v) && (bfs.distTo[w] > bfs.distTo[v] + 1)) {
                    StdOut.println("edge " + v + "-" + w);
                    StdOut.println("distTo[" + v + "] = " + bfs.distTo[v]);
                    StdOut.println("distTo[" + w + "] = " + bfs.distTo[w]);
                    return;
                }
            }
        }

        // check that v = edgeTo[w] satisfies distTo[w] + distTo[v] + 1
        // provided v is reachable from s
        for (int w = 0; w < G.v(); w++) {
            if (!bfs.hasPathTo(w) || w == s) continue;
            int v = bfs.edgeTo[w];
            if (bfs.distTo[w] != bfs.distTo[v] + 1) {
                StdOut.println("shortest path edge " + v + "-" + w);
                StdOut.println("distTo[" + v + "] = " + bfs.distTo[v]);
                StdOut.println("distTo[" + w + "] = " + bfs.distTo[w]);
                return;
            }
        }
    }
}