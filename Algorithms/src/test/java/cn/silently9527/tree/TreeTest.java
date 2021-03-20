package cn.silently9527.tree;

import cn.silently9527.map.RedBlack234RedBlackTreeMap;
import cn.silently9527.map.RedBlack234RedBlackTreeMapV2;
import cn.silently9527.map.RedBlack23RedBlackTreeMap;
import org.junit.Test;

import java.io.IOException;

public class TreeTest {

    @Test
    public void test() throws IOException {
//        8,18,5,15,17,25,40,80,30,60,16
//        RedBlack23RedBlackTreeMap<Integer, String> map = new RedBlack23RedBlackTreeMap<>();
//        RedBlack234RedBlackTreeMap<Integer, String> map = new RedBlack234RedBlackTreeMap<>();
        RedBlack234RedBlackTreeMapV2<Integer, String> map = new RedBlack234RedBlackTreeMapV2<>();
        map.put(8, "80");
        map.put(18, "180");
        map.put(5, "50");
        map.put(15, "150");
        map.put(17, "170");
        map.put(25, "250");
        map.put(40, "40");
        map.put(80, "80");
        map.put(30, "30");
        map.put(60, "60");
        map.put(16, "16");

        map.draw("/Users/huaan9527/Desktop/redBlack3.png");


        System.out.println(map.get(25));
        System.out.println(map.get(15));

        System.out.println("====>");
        map.keys().forEach(System.out::println);

        System.out.println("====>");
        map.nodes().forEach(System.out::println);


    }


    @Test
    public void testDeleteMin() throws IOException {
//       80，50，100，90
        RedBlack23RedBlackTreeMap<Integer, String> map = new RedBlack23RedBlackTreeMap<>();
        map.put(80, "80");
        map.put(50, "50");
        map.put(100, "100");
        map.put(90, "90");


        map.deleteMin();
        System.out.println("====>");
        map.nodes().forEach(System.out::println);


        map.draw("/Users/huaan9527/Desktop/redBlack4.png");

    }

    @Test
    public void testDeleteMax() throws IOException {
//       80，50，100，90
        RedBlack23RedBlackTreeMap<Integer, String> map = new RedBlack23RedBlackTreeMap<>();
        map.put(80, "80");
        map.put(50, "50");
        map.put(100, "100");
        map.put(90, "90");

        map.draw("/Users/huaan9527/Desktop/redBlack4.png");
        map.deleteMax();
        System.out.println("====>");
        map.nodes().forEach(System.out::println);


        map.draw("/Users/huaan9527/Desktop/redBlack5.png");

    }

    @Test
    public void testDelete() throws IOException {
//       80，50，100，90
        RedBlack23RedBlackTreeMap<Integer, String> map = new RedBlack23RedBlackTreeMap<>();
        map.put(8, "80");
        map.put(18, "180");
        map.put(5, "50");
        map.put(15, "150");
        map.put(17, "170");
        map.put(25, "250");
        map.put(40, "40");
        map.put(80, "80");
        map.put(30, "30");
        map.put(60, "60");
        map.put(16, "16");

        map.draw("/Users/huaan9527/Desktop/redBlack4.png");
        map.delete(40);
        System.out.println("====>");
        map.nodes().forEach(System.out::println);


        map.draw("/Users/huaan9527/Desktop/redBlack5.png");

    }


}
