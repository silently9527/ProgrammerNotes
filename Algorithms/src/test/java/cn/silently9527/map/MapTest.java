package cn.silently9527.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {

    @Test
    public void testLinkedMap() {
        Map<String, String> map = new LinkedMap<>();
        map.put("name", "Silently9527");
        map.put("website", "http://silently9527.cn");
        map.put("juejin-name", "Silently9527");

        map.keys().forEach(key -> {
            System.out.println(key + ":" + map.get(key));
        });

        map.delete("juejin-name");
        System.out.println("==========");
        map.keys().forEach(key -> {
            System.out.println(key + ":" + map.get(key));
        });

    }

    @Test
    public void testArraySortedMap() {
        Map<Integer, String> map = new ArraySortedMap<>(10);
        map.put(1, "name=Silently9527");
        map.put(2, "website=http://silently9527.cn");
        map.put(3, "juejin-name=Silently9527");

        map.keys().forEach(key -> {
            System.out.println(key + ":" + map.get(key));
        });

        map.delete(3);
        map.delete(1);
        map.delete(5);
        map.put(3, "juejin-name=Silently9527");
        System.out.println("==========");
        map.keys().forEach(key -> {
            System.out.println(key + ":" + map.get(key));
        });

    }

    @Test
    public void testSeparateChainingHashMap(){
        Map<Integer, String> map = new SeparateChainingHashMap<>(10);
        map.put(1, "name=Silently9527");
        map.put(2, "website=http://silently9527.cn");
        map.put(3, "juejin-name=Silently9527");

        System.out.println(map.get(3));
        map.delete(3);
        System.out.println(map.get(3));
    }



    @Test
    public void testLinearProbingHashMap(){
        Map<Integer, String> map = new LinearProbingHashMap<>(10);
        map.put(1, "name=Silently9527");
        map.put(2, "website=http://silently9527.cn");
        map.put(3, "juejin-name=Silently9527");

        System.out.println(map.get(3));
        map.delete(3);
        System.out.println(map.get(3));
    }








}