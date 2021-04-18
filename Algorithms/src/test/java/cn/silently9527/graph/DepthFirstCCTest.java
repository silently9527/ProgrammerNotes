package cn.silently9527.graph;

import cn.silently9527.graph.entity.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstCCTest {

    @Test
    public void test() {
        Graph graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(5, 3);

        graph.addEdge(6, 7);

        graph.addEdge(8, 9);

        DepthFirstCC cc = new DepthFirstCC(graph);

        System.out.println(cc.connected(0,5));
        System.out.println(cc.connected(1,2));

        System.out.println(cc.count());

        Graph graph1 = new Graph(10);
        graph1.addEdge(0, 1);
        Cycle cycle = new Cycle(graph1);
        System.out.println(cycle.hasCycle());
    }

}