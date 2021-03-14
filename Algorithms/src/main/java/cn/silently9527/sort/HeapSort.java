package cn.silently9527.sort;

public class HeapSort implements SortTemplate {
    @Override
    public void sort(Comparable[] array) {
        int size = array.length;
        for (int k = size / 2; k >= 0; k--) {
            sink(array, k, size);
        }
        while (size > 0) {
            exch(array, 0, --size);
            sink(array, 0, size);
        }
    }


    private void sink(Comparable[] queue, int k, int size) {
        while (2 * k + 1 < size) {
            int i = 2 * k + 1;
            if (i < size - 1 && less(queue[i], queue[i + 1])) {
                i++;
            }
            if (less(queue[i], queue[k])) {
                break;
            }
            exch(queue, i, k);
            k = i;
        }
    }

}
