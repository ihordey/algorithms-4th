package utils;

import graphs.undirectedGraphs.Graph;
import stdLib.In;

import java.io.File;

public final class GraphTestUtils {
    private GraphTestUtils() {
    }

    public static Graph getGraph(String pathToFile) {
        return new Graph(new In(new File(pathToFile)));
    }
}
