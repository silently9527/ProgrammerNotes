package cn.silently9527.graph;

import cn.silently9527.basic.queue.LinkedListQueue;
import cn.silently9527.basic.queue.Queue;
import cn.silently9527.basic.stack.LinkedListStack;
import cn.silently9527.basic.stack.Stack;
import cn.silently9527.graph.entity.Graph;

public class BreadthFirstPaths {
    private boolean marked[];
    private int[] edgeTo;
    private int s;
    private Queue<Integer> queue = new LinkedListQueue<>();

    public BreadthFirstPaths(Graph graph, int s) {
        this.s = s;
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];

        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        this.marked[s] = true;
        this.queue.enqueue(s);
        while (!this.queue.isEmpty()) {
            Integer v = this.queue.dequeue();
            for (int w : graph.adj(v)) {
                if (!this.marked[w]) {
                    this.marked[w] = true;
                    this.edgeTo[w] = v;
                    this.queue.enqueue(w);
                }
            }
        }


    }

    public boolean hasPathTo(int v) {
        return this.marked[v];
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
