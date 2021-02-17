package cn.silently9527.unionfind;

public abstract class AbstractUF implements UF {
    protected int[] id;
    protected int count;

    public AbstractUF(int N) {
        count = N;

        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
