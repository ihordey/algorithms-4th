package practice.graphs.undirected_graph;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;

    public BreadthFirstSearch(Graph graph, int s) {
        this.marked = new boolean[graph.vertices()];
        this.edgeTo = new int[graph.vertices()];
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        final Queue<Integer> queue = new LinkedBlockingQueue<>();
        marked[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            final Integer v = queue.poll();
            for (int w : graph.edges(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}
