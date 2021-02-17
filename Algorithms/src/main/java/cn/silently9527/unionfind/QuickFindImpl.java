package cn.silently9527.unionfind;

public class QuickFindImpl extends AbstractUF {
    public QuickFindImpl(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) { //如果相等表示p与q已经属于同一分量中
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId; //把分量中所有的值都统一成qId
            }
        }
        count--; //连通分量数减一
    }

}
