package my.graph;

import fundamentals.bagsQueuesStacks.Stack;
import stdLib.In;

import static stdLib.StdOut.print;
import static stdLib.StdOut.println;

/**
 * User: Vanya
 * Date: 10/31/14
 */
public class MyDepthFirstPaths {
    private final  int s;
    private boolean [] marked;
    private int[] edgeTo;

    public MyDepthFirstPaths(MyGraph graph,  int s) {
        this.s = s;
        this.marked = new boolean[graph.getVertexes()];
        this.edgeTo = new int[graph.getVertexes()];
        dfs(graph, s);
    }

    private void dfs(MyGraph graph, int v) {
       marked[v] = true;
        for (int w : graph.adj(v)) {
            if(!marked[w]){
               edgeTo[w] = v;
               dfs(graph, w);
            }
        }
    }

    public  boolean hasPathTo(int v){
        return  marked[v];
    }

    public Iterable<Integer> pathTo(int v){
      if(!hasPathTo(v)) return null;
        Stack path = new Stack();
        for (int i = v; s != i;  i = edgeTo[i]) {
              path.push(i);
        }
        path.push(s);
        return path;
    }


    public static void main(String[] args) {
        MyDepthFirstPaths dfp = new MyDepthFirstPaths(new MyGraph(new In(args[0])), Integer.parseInt(args[1]));
        int pathTo =  Integer.parseInt(args[2]);
        println("path from "+dfp.s+" to "+pathTo+" is " +dfp.hasPathTo(pathTo));
        print("path : ");
        for (Integer vertex : dfp.pathTo(pathTo)) {
           print(vertex+" ");
        }

    }
}
