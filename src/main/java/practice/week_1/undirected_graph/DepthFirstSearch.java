package practice.week_1.undirected_graph;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph graph, int v) {
        marked = new boolean[graph.vertices()];
        dfs(graph, v);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (Integer w : graph.edges(v)) {
            if (!marked(w)) {
                dfs(graph, w);
            }
        }
    }


    public boolean marked(int v) {
        return marked[v];
    }

    public int getCount() {
        return count;
    }
}
