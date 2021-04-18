package cn.silently9527.graph;

import cn.silently9527.graph.entity.Graph;

public class DepthFirstCC {
    private boolean marked[];
    private int count;
    private int[] ids;

    public DepthFirstCC(Graph graph) {
        this.marked = new boolean[graph.V()];
        this.ids = new int[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            if (!this.marked[v]) {
                dfs(graph, v);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        this.marked[v] = true;
        this.ids[v] = count;
        for (int w : graph.adj(v)) {
            if (!this.marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id(v) == id(w);
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return ids[v];
    }

}
