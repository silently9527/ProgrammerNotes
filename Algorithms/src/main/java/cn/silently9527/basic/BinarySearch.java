package cn.silently9527.basic;

public class BinarySearch {

    /**
     * 二分查找
     * @param key
     * @param arr
     * @return 存在返回对应的下标，不存在返回 -1
     */
    public static int search(int key, int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > arr[mid]) {
                lo = mid + 1;
            } else if (key < arr[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
