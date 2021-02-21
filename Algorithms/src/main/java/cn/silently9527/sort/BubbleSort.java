package cn.silently9527.sort;

public class BubbleSort implements SortTemplate {

    @Override
    public void sort(Comparable[] array) {
        int length = array.length - 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (less(array[j + 1], array[j])) {
                    exch(array, j, j + 1);
                }
            }
        }
    }

}
