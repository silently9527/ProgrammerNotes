package cn.silently9527.graph;

import cn.silently9527.graph.entity.Graph;
import cn.silently9527.map.Map;
import cn.silently9527.map.RedBlack23RedBlackTreeMap;

import java.util.Arrays;


public class SymbolGraph {
    private Map<String, Integer> map = new RedBlack23RedBlackTreeMap<>();
    private String[] keys;
    private Graph graph;

    //a,b,c,d\n
    //b,a,h,l,p\n
    //g,s,z
    public SymbolGraph(String text) {
        Arrays.stream(text.split("\n")).forEach(line -> {
            String[] split = line.split(",");
            for (int i = 0; i < split.length; i++) {
                map.put(split[i], i);
            }
        });

        this.keys = new String[map.size()];
        map.keys().forEach(key -> {
            this.keys[this.map.get(key)] = key;
        });

        this.graph = new Graph(this.keys.length);
        Arrays.stream(text.split("\n")).forEach(line -> {
            String[] split = line.split(",");
            int v = this.map.get(split[0]);
            for (int i = 1; i < split.length; i++) {
                this.graph.addEdge(v, this.map.get(split[i]));
            }
        });

    }

    public boolean contains(String key) {
        return map.contains(key);
    }

    public int index(String key) {
        return map.get(key);
    }

    public String name(int index) {
        return this.keys[index];
    }

    public Graph graph() {
        return this.graph;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("323\n2323".split("\n")));
    }
}
