package my.graph;

import fundamentals.bagsQueuesStacks.Queue;
import fundamentals.bagsQueuesStacks.Stack;
import stdLib.In;

import static stdLib.StdOut.print;
import static stdLib.StdOut.println;

/**
 * User: Vanya
 * Date: 11/1/14
 */
public class MyBreadthFirstPath {
    private  int s;
    private boolean[] marked;
    private int[] edgeTo;

    public MyBreadthFirstPath(MyGraph graph, int s) {
        this.s = s;
        this.marked = new boolean[graph.getVertexes()];
        this.edgeTo = new int[graph.getVertexes()];
        bfs(graph,s);
    }

    private void bfs(MyGraph graph, int s) {
        Queue<Integer> vertexes = new Queue<Integer>();
        vertexes.enqueue(s);
        while (!vertexes.isEmpty()){
            int v = vertexes.dequeue();
            marked[v] = true;

            for (int w : graph.adj(v)) {
                if(!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    vertexes.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return  marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        Stack path = new Stack();
        for (int i = v; i != s; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        MyBreadthFirstPath bfp = new MyBreadthFirstPath(new MyGraph(new In(args[0])), Integer.parseInt(args[1]));
        int pathTo =  Integer.parseInt(args[2]);
        println("path from " + bfp.s + " to " + pathTo + " is " + bfp.hasPathTo(pathTo));
        print("path : ");
        for (Integer vertex : bfp.pathTo(pathTo)) {
            print(vertex+" ");
        }
    }
}
