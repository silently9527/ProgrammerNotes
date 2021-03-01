package cn.silently9527.sort;

/**
 * 插入排序
 */
public class InsertionSort implements SortTemplate {

    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                exch(array, j, j - 1);
            }
        }
    }

}
