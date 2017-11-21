package practice.graphs.undirected_graph;

import stdLib.In;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Integer>[] adjacencyList;
    private int edges;

    public Graph(int v) {
        adjacencyList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        this.edges = in.readInt();
        for (int i = 0; i < edges; i++) {
            addEdge(in.readInt(), in.readInt());
        }
    }

    public int edges() {
        return edges;
    }

    public int vertices() {
        return adjacencyList.length;
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    public Iterable<Integer> edges(int v) {
        return adjacencyList[v];
    }
}
