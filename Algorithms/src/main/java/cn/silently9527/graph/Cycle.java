package cn.silently9527.graph;

import cn.silently9527.graph.entity.Graph;

public class Cycle {
    private boolean marked[];
    private boolean hashCycle;

    public Cycle(Graph graph) {
        this.marked = new boolean[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!this.marked[s]) {
                dfs(graph, s, s);
            }
        }
    }

    private void dfs(Graph graph, int v, int pV) {
        this.marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!this.marked[w]) {
                this.dfs(graph, w, v);
            } else if (w != pV) {
                this.hashCycle = true;
                return;
            }
        }
    }

    public boolean hasCycle() {
        return hashCycle;
    }
}
