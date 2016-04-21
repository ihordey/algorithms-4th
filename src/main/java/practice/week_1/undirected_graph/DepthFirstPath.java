package practice.week_1.undirected_graph;

import java.util.Stack;

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

    public boolean marked(int w) {
        return marked[w];
    }

    public Stack<Integer> path(int w) {
        final Stack<Integer> result = new Stack<>();

        if (marked(w)) {
           for (int k = w; k != s; k = edgesTo[k]){
             result.add(k);
           }
            result.add(s);
        }
        return result;
    }

}
