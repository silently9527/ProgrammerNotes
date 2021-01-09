package cn.silently9527;

import java.util.List;

public interface Cluster {
    void addNode(Node node);

    default void removeNode(Node node) {
        this.removeNode(node.getName());
    }

    void removeNode(String nodeName);

    Node get(String key);

    List<Node> getNodes();
}
