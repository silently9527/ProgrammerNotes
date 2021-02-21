package cn.silently9527.sort;

public class ShellSort implements SortTemplate {

    @Override
    public void sort(Comparable[] array) {
        int gap = 1;
        int length = array.length;

        while (gap < length / 3) {
            gap = 3 * gap + 1;
        }

        while (gap >= 1) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap && less(array[j], array[j - gap]); j -= gap) {
                    exch(array, j, j - gap);
                }
            }
            gap = gap / 3;
        }

    }

}
