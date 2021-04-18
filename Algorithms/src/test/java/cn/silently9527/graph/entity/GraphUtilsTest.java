package cn.silently9527.graph.entity;

import cn.silently9527.graph.utils.GraphUtils;
import org.junit.Test;

public class GraphUtilsTest {

    @Test
    public void numberOfSelfLoops() {
        Graph graph = new Graph(2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 0);

        System.out.println(GraphUtils.numberOfSelfLoops(graph));

        System.out.println(graph);
    }
}