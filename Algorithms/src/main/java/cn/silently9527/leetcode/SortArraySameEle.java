package cn.silently9527.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//有序数据求相同元素
public class SortArraySameEle {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 3, 4, 5};
        Integer[] b = new Integer[]{4, 5, 9, 10};
        System.out.println(Arrays.toString(SortArraySameEle.get(a, b)));
    }

    public static Integer[] get(Integer[] a, Integer[] b) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                result.add(a[i]);
                i++;
                j++;
            }
        }
        return result.toArray(new Integer[]{});
    }

}
