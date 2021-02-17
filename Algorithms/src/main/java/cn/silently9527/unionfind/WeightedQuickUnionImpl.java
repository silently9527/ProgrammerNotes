package cn.silently9527.unionfind;

public class WeightedQuickUnionImpl extends AbstractUF {
    private int[] sz;

    public WeightedQuickUnionImpl(int N) {
        super(N);
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p); //找出q p的根触点
        int qRoot = find(q);
        if (pRoot == qRoot) { //处于同一分量不做处理
            return;
        }
        //小树合并到大树
        if (sz[pRoot] < sz[qRoot]) {
            sz[qRoot] += sz[pRoot];
            id[pRoot] = qRoot;
        } else {
            sz[pRoot] += sz[qRoot];
            id[qRoot] = pRoot;
        }
        count--;
    }

    @Override
    public int find(int p) {
        //找出p所在分量的根触点
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
}
