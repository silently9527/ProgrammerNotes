package cn.silently9527;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 无向图
 */
public class Graph {
    private int vertexCount;            // 顶点数
    private int edgeCount;                // 边数
    private LinkedList<Integer>[] adj;    // 邻接表数组

    public Graph(int v) {
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) adj[i] = new LinkedList<>();// 初始化邻接表数组
        this.vertexCount = v;
    }
//    public Graph(In in) {
//        this(in.readInt());
//        int e = in.readInt();//得到边数
//        // 读取每条边，进行图的初始化操作
//        for(int i = 0; i<e;i++){
//            int v = in.readInt();     // 起点
//            int w = in.readInt();     // 终点
//            addEdge(v, w);
//        }
//    }

    /*** 增加一条边*/
    public void addEdge(int start, int end) {
        adj[start].add(end);
        adj[end].add(start);
        this.edgeCount++;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    /**
     * 返回顶点v的邻接表
     */
    public LinkedList<Integer> adj(int v) {
        return adj[v];
    }
    /** 把图转化成标准字符串形式*/
//    public String toString(){
//        String NEWLINE = System.getProperty("line.separator");
//        StringBuilder sb = new StringBuilder();
//        sb.append("vertex count: ").append(getVertexCount())
//                .append(" edge count: ").append(getEdgeCount())
//                .append(Config.NEWLINE);
//        for (int v = 0; v < getVertexCount();v++){
//            LinkedList<Integer> list = adj(v);
//            sb.append(v).append(":\t").append("[");
//            for (int i=0; i < list.size();i++){
//                sb.append(list.get(i)).append(",");
//            }
//            sb.deleteCharAt(sb.length() - 1);
//            sb.append("]").append(NEWLINE);
//        }
//        return sb.toString();
//    }
//    public static void main(String[] args) {
//        String dir = Graph.class.getPackage().getName().replace(".", "/");
//        String path = Graph.class.getClassLoader().getResource(dir+"/tinyG.txt").getPath();
//        In in = new In(new File(path));
//        Graph g = new Graph(in);
//        System.out.println(g.toString());
//    }

    /**
     * 计算自环的个数
     */
    public static int numberOfSelfLoops(Graph g) {
        int count = 0;
        for (int v = 0; v < g.getVertexCount(); v++)
            for (int w : g.adj(v))
                if (v == w) count++;
        return count / 2; // 每条边计算了两次
    }

    public static void main(String[] args) {
        Graph graph = new Graph(1);
        graph.addEdge(0, 0);

//        System.out.println(numberOfSelfLoops(graph));
//
//        System.out.println('b'+'c');
//        System.out.println('a'+0);
//        System.out.println(Math.abs(-134576453435643l));
//        System.out.println(14%-3);

//        System.out.println(2.0e-6*100000000.1);
//        System.out.println(2.0e-6 == Math.pow(20, -6));
//        System.out.println(4.1>=4);
//        System.out.println(1+2+"3");

//        String result = "";
//        for (int a = 10; a > 0; a = a >> 1) {
//            result = a % 2 + result;
//        }
//        System.out.println(result);

//        int[][] a = {{1, 2, 3}, {4, 5, 6}};
//        int[][] b = new int[a[0].length][a.length];
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[i].length; j++) {
//                b[j][i] = a[i][j];
//            }
//        }
//
//        for (int[] ints : b) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }

//        int a = 1024;
//        int count = 0;
//        while ((a = a >> 1) > 0) {
//            count++;
//        }
//        System.out.println(count-1);

        int[] array = {1, 6, 31, 4, 5, 18, 6, 4, 0, 8};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(search(array, 0, array.length - 1, 0));
        System.out.println(search2(array, 0));
    }


    public static int search(int[] array, int lo, int hi, int key) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < array[mid]) {
            return search(array, lo, mid - 1, key);
        } else if (key > array[mid]) {
            return search(array, mid + 1, hi, key);
        } else {
            return mid;
        }
    }

    public static int search2(int[] array, int key) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < array[mid]) {
                hi = mid - 1;
            } else if (key > array[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
