package cn.silently9527.graph;

import cn.silently9527.graph.entity.Graph;

public class TwoColorGraph {
    private boolean twoColor = true;
    private boolean[] marked;
    private boolean[] color;

    public TwoColorGraph(Graph graph) {
        this.marked = new boolean[graph.V()];
        this.color = new boolean[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            if (!this.marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Graph graph, int v) {
        this.marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!this.marked[w]) {
                this.color[w] = !this.color[v];
                dfs(graph, w);
            } else if (this.color[w] == this.color[v]) {
                this.twoColor = false;
                return;
            }
        }
    }

    public boolean isTwoColor() {
        return twoColor;
    }
}
