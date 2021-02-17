package cn.silently9527.unionfind;

public interface UF {
    void union(int p, int q); //在p与q之间添加一条连接

    int find(int p); //找出p所在分量的标识符

    boolean connected(int p, int q); //判断出p与q是否存在于同一个分量中

    int count(); //统计出连通分量的数量
}
