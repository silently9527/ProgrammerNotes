package cn.silently9527.graph.entity;

import cn.silently9527.basic.queue.LinkedListQueue;

public class Graph {
    private final int v;
    private int e;
    private LinkedListQueue<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.adj = (LinkedListQueue<Integer>[]) new LinkedListQueue[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedListQueue<>();
        }
    }

    public int V() {
        return v;
    }

    public int E() {
        return e;
    }

    public void addEdge(int v, int w) {
        this.adj[v].enqueue(w);
        this.adj[w].enqueue(v);
        this.e++;
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(v).append(" 个顶点，").append(e).append(" 条边\n");
        for (int i = 0; i < v; i++) {
            sb.append(i).append(": ");
            for (int j : this.adj[i]) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
