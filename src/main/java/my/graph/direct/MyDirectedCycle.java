package my.graph.direct;

import fundamentals.bagsQueuesStacks.Stack;
import graphs.directedGraphs.Digraph;
import graphs.directedGraphs.DirectedCycle;
import stdLib.In;

import static stdLib.StdOut.print;
import static stdLib.StdOut.println;

/**
 * User: Vanya
 * Date: 11/13/14
 */
public class MyDirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> stack;

    public MyDirectedCycle(Digraph graph) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        onStack = new boolean[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            dfs(graph,v);
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (Integer w : graph.adj(v)) {
            if(hasCycle()) {
              return;
            }else if(!marked[w]){
               edgeTo[w] = v;
               dfs(graph, w);
            }else if (onStack[w]){
               stack = new Stack<Integer>();
                for (int c = v; c != w; c = edgeTo[c]) {
                  stack.push(c);
                }
                stack.push(w);
//                stack.push(v);
            }
            onStack[v] = false;
        }
    }

    public boolean hasCycle() {
        return stack != null;
    }

    public void printCycle(){
        for (Integer v : stack) {
            print(" "+v);
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph graph = new Digraph(in);
        MyDirectedCycle dc = new MyDirectedCycle(graph);
        println(dc.hasCycle() ? "Has CYCLE" : "NO CYCLE");
        if(dc.hasCycle()){
          dc.printCycle();
        }
    }

}
