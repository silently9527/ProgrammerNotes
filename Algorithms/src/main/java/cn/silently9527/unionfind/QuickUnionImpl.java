package cn.silently9527.unionfind;

public class QuickUnionImpl extends AbstractUF {
    public QuickUnionImpl(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        //找出p所在分量的根触点
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p); //找出q p的根触点
        int qRoot = find(q);
        if (pRoot == qRoot) { //处于同一分量不做处理
            return;
        }
        id[pRoot] = qRoot; //根节点
        count--;
    }

}
