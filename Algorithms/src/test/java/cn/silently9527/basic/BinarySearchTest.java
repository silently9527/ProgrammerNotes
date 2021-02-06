package cn.silently9527.basic;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void search() {
        int[] array = new int[]{3, 4, 6, 11, 44, 0, 1, 5, 23, 65, 12, 56, 88, 8, 9, 2};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        System.out.println(BinarySearch.search(44, array));
        System.out.println(BinarySearch.search(33, array));

    }
}