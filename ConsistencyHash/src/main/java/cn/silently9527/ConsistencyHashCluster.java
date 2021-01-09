package cn.silently9527;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistencyHashCluster extends AbstractCluster {
    private static final int DEFAULT_VNODE_NUM = 150;

    private int vNodeNum;
    private SortedMap<Long, Node> vNodes = new TreeMap<>();

    public ConsistencyHashCluster() {
        this(DEFAULT_VNODE_NUM);
    }

    public ConsistencyHashCluster(int vNodeNum) {
        this.vNodeNum = vNodeNum;
    }

    @Override
    public void addNode(Node node) {
        this.nodes.add(node);
        for (int i = 0; i < vNodeNum; i++) {
            String vNodeName = node.getName() + "_vnode_" + i;
            vNodes.put(hash(vNodeName), node);
        }
    }

    @Override
    public void removeNode(String nodeName) {
        this.nodes.removeIf(node -> node.getName().equals(nodeName));
        for (int i = 0; i < vNodeNum; i++) {
            String vNodeName = nodeName + "_vnode_" + i;
            vNodes.remove(hash(vNodeName));
        }
    }

    @Override
    public Node get(String key) {
        long hash = hash(key);
        SortedMap<Long, Node> subMap = vNodes.tailMap(hash);
        if (!subMap.isEmpty()) {
            return subMap.get(subMap.firstKey());
        }
        return vNodes.get(vNodes.firstKey());
    }

}
