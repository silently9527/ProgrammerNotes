package cn.silently9527.consistency.hash;

import org.junit.Test;

import java.util.stream.IntStream;

public class ConsistencyHashTest {

    @Test
    public void test() {
        Cluster cluster = new ConsistencyHashCluster();
        cluster.addNode(new Node("node1", "192.168.16.1", "7001"));
        cluster.addNode(new Node("node2", "192.168.16.2", "7002"));
        cluster.addNode(new Node("node3", "192.168.16.3", "7003"));
        cluster.addNode(new Node("node4", "192.168.16.4", "7004"));

        int dataCount = 200000;
        String preKey = "Data_";

        for (int index = 0; index < dataCount; index++) {
            Node node = cluster.get(preKey + index);
            node.put(preKey + index, "测试");
        }

        System.out.println("数据分布情况：");
        cluster.getNodes().forEach(node -> {
            System.out.println("Node Name:" + node.getName() + ", 数据量:" + node.dataSize());
        });

        //缓存命中率
        long hitCount = IntStream.range(0, dataCount)
                .filter(index -> cluster.get(preKey + index).get(preKey + index) != null)
                .count();
        System.out.println("正常情况命中率：" + hitCount * 1f / dataCount);


        cluster.addNode(new Node("node5", "192.168.16.5", "7005"));
        hitCount = IntStream.range(0, dataCount)
                .filter(index -> cluster.get(preKey + index).get(preKey + index) != null)
                .count();
        System.out.println("添加节点node5之后命中率：" + hitCount * 1f / dataCount);


//        cluster.removeNode("node3");
//        hitCount = IntStream.range(0, dataCount)
//                .filter(index -> cluster.get(preKey + index).get(preKey + index) != null)
//                .count();
//        System.out.println("删除节点node3之后命中率：" + hitCount * 1f / dataCount);


    }
}
