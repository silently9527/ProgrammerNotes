package cn.silently9527.graph;

import cn.silently9527.basic.stack.LinkedListStack;
import cn.silently9527.basic.stack.Stack;
import cn.silently9527.graph.entity.Graph;

public class DepthFirstPaths {
    private boolean marked[];
    private int[] edgeTo;
    private int s;

    DepthFirstPaths(Graph graph, int s) {
        this.s = s;
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        this.marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                this.edgeTo[w] = v;
                this.dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            throw new IllegalStateException("s不能到达v");
        }
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(v);
        while (edgeTo[v] != s) {
            stack.push(edgeTo[v]);
            v = edgeTo[v];
        }
        stack.push(s);
        return stack;
    }
}
