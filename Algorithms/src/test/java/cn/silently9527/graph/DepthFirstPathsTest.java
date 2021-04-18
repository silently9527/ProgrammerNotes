package cn.silently9527.graph;

import cn.silently9527.graph.entity.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstPathsTest {

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

        DepthFirstPaths paths = new DepthFirstPaths(graph, 0);
        System.out.println(paths.hasPathTo(5));
        System.out.println(paths.hasPathTo(2));
        System.out.println(paths.hasPathTo(6));

        paths.pathTo(5).forEach(System.out::print);
        System.out.println();
        paths.pathTo(4).forEach(System.out::print);
        System.out.println();
        paths.pathTo(2).forEach(System.out::print);


    }


}