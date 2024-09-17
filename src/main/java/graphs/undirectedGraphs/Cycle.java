package  graphs.undirectedGraphs;

import fundamentals.bagsQueuesStacks.Stack;

/*************************************************************************
 *  Compilation:  javac Cycle.java
 *  Dependencies: Graph.java Stack.java
 *
 *  Identifies a cycle.
 *  Runs in O(E + V) time.
 *
 *************************************************************************/

public class Cycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public Cycle(Graph graph) {
        if (hasSelfLoop(graph)) return;
        if (hasParallelEdges(graph)) return;
        marked = new boolean[graph.v()];
        edgeTo = new int[graph.v()];
        for (int v = 0; v < graph.v(); v++)
            if (!marked[v])
                dfs(graph, -1, v);
    }

    private boolean hasSelfLoop(Graph graph) {
        for (int v = 0; v < graph.v(); v++) {
            for (int w : graph.adj(v)) {
                if (v == w) {
                    cycle = new Stack<>();
                    cycle.push(v);
                    cycle.push(v);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasParallelEdges(Graph graph) {
        marked = new boolean[graph.v()];
        for (int v = 0; v < graph.v(); v++) {
            for (int w : graph.adj(v)) {
                if (marked[w]) {
                    cycle = new Stack<>();
                    cycle.push(v);
                    cycle.push(w);
                    cycle.push(v);
                    return true;
                }
                marked[w] = true;
            }
            for (int w : graph.adj(v)) {
                marked[w] = false;
            }
        }
        return false;
    }

    public boolean hasCycle()        { return cycle != null; }
    public Iterable<Integer> cycle() { return cycle;         }

    private void dfs(Graph graph, int u, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (cycle != null) return;
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, v, w);
            }
            else if (w != u) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }
}

