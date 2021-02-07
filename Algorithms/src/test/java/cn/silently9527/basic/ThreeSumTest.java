package cn.silently9527.basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumTest {

    @Test
    public void count1() {
        System.out.println(ThreeSum.count1(new int[]{1, 2, -3, 5, 7, 9, 8}));
        System.out.println(ThreeSum.count2(new int[]{1, 2, -3, 5, 7, 9, 8}));
        System.out.println(ThreeSum.count3(new int[]{1, 2, -3, 5, 7, 9, 8}));
    }

}