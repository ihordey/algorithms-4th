package practice.graphs.undirected_graph;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class DepthFirstPath {
    private boolean[] marked;
    private int[] edgesTo;
    private int s;

    public DepthFirstPath(Graph graph, int s) {
        this.marked = new boolean[graph.edges()];
        this.edgesTo = new int[graph.edges()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int s) {
        marked[s] = true;
        for (int w : graph.edges(s)) {
            if (!marked[w]) {
                edgesTo[w] = s;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public Deque<Integer> path(int w) {
        final Deque<Integer> result = new LinkedBlockingDeque<>();

        if (hasPathTo(w)) {
           for (int k = w; k != s; k = edgesTo[k]){
             result.addLast(k);
           }
            result.add(s);
        }
        return result;
    }

}
