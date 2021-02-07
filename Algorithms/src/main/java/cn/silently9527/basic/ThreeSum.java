package cn.silently9527.basic;

import java.util.Arrays;

public class ThreeSum {

    public static int count1(int[] arr) {
        int length = arr.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int count2(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (BinarySearch.search(-arr[i], arr) > i) {
                count++;
            }
        }
        return count;
    }

    public static int count3(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (BinarySearch.search(-arr[i]-arr[j], arr) > j) {
                    count++;
                }
            }
        }
        return count;
    }


}
