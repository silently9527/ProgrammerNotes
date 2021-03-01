package cn.silently9527.sort;

/**
 * 选择排序
 */
public class SelectionSort implements SortTemplate {

    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            exch(array, i, min);
        }
    }

}
