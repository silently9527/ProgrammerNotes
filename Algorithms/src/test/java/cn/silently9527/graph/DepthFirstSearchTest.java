package cn.silently9527.graph;

import cn.silently9527.graph.entity.Graph;
import org.junit.Test;

public class DepthFirstSearchTest {

    @Test
    public void test() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(5, 3);
        graph.addEdge(6, 7);

        DepthFirstSearch search = new DepthFirstSearch(graph, 0);
        System.out.println(search.count());
        System.out.println(search.marked(6));
        System.out.println(search.marked(7));
        System.out.println(search.marked(2));
        System.out.println(search.marked(5));
    }

    @Test
    public void test1() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(4, 3);
        graph.addEdge(5, 3);

        //graph.addEdge(2, 4);

        TwoColorGraph twoColorGraph = new TwoColorGraph(graph);
        System.out.println(twoColorGraph.isTwoColor());
    }


}