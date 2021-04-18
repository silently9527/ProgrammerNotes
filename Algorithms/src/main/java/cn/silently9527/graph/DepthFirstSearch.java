package cn.silently9527.graph;

import cn.silently9527.graph.entity.Graph;

public class DepthFirstSearch {
    private boolean marked[];
    private int count;

    public DepthFirstSearch(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        this.dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        count++;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}
