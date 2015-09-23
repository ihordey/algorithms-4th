package my.graph;

import fundamentals.bagsQueuesStacks.Bag;
import stdLib.In;

import static stdLib.StdOut.print;
import static stdLib.StdOut.println;

/**
 * User: Vanya
 * Date: 10/31/14
 *  path : src/main/resources/tinyG.txt
 */
public class MyGraph {
   private final int v;
   private  int e;
   private Bag<Integer>[] adj;

    public MyGraph(int v) {
        this.v = v;
        adj = (Bag<Integer>[])new Bag[v];
        for (int i = 0; i < v; i++) {
             adj[i] = new Bag();
        }
    }

    public MyGraph(int v, int e) {
        this(v);
        this.e = e;
    }

    public MyGraph(In in) {
        this(in.readInt(),in.readInt());
        pupulate(in,this);
    }

    public void addEdge(int v, int w){
      e++;
      adj[v].add(w);
      adj[w].add(v);
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public  void pupulate(In in, MyGraph graph) {
        while(in.hasNextLine()){
            graph.addEdge(in.readInt(), in.readInt());
        }
    }

    public int getVertexes() {
        return v;
    }

    public int getEdges() {
        return e;
    }

    public static void main(String[] args) {
        println("in source : " + args[0]);
        In in = new In(args[0]);

        MyGraph graph = new MyGraph(in);
        int searchV = 0;
        print(searchV + " : ");
        for (Integer w : graph.adj(searchV)) {
            print(w + " ");
        }

    }
}
