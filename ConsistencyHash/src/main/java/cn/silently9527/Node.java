package cn.silently9527;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 真实节点
 */
public class Node {
    private String name;
    private String host;
    private String port;
    private Map<String, Object> data = new ConcurrentHashMap<>();

    public Node(String name, String host, String port) {
        this.name = name;
        this.host = host;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public void remove(String key) {
        data.remove(key);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public int dataSize(){
        return this.data.size();
    }
}
