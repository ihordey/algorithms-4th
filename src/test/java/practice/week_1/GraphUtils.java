package practice.week_1;

import practice.week_1.undirected_graph.Graph;
import stdLib.In;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface GraphUtils {
    Path TINY_GPATH_PATH = Paths.get("src/test/resources/week_1/undirected_graph/tinyG.txt");

    static Graph tinyGraph() {
        return new Graph(new In(GraphUtils.TINY_GPATH_PATH.toFile()));
    }
}
