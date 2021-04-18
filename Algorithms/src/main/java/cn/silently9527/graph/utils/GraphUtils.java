package cn.silently9527.graph.utils;

import cn.silently9527.graph.entity.Graph;

public class GraphUtils {

    public static int degree(Graph graph, int v) {
        int degree = 0;
        for (int w : graph.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph graph) {
        int maxDegree = 0;
        for (int v = 0; v < graph.V(); v++) {
            int degree = degree(graph, v);
            if (maxDegree < degree) {
                maxDegree = degree;
            }
        }
        return maxDegree;
    }

    public static double avgDegree(Graph graph) {
        return 2.0 * graph.E() / graph.V();
    }

    public static int numberOfSelfLoops(Graph graph) {
        int count = 0;
        for (int v = 0; v < graph.V(); v++) {
            for (int w : graph.adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        return count / 2;
    }
}
