package cn.silently9527.sort;

/**
 * 归并排序
 */
public class MergeSort2 implements SortTemplate {
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] array) {
        aux = array.clone();
        doSort(aux, array, 0, array.length - 1);
    }

    private void doSort(Comparable[] src, Comparable[] dest, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        if (hi - lo < 5) { //测试，小于5就使用插入排序
            insertionSort(dest, lo, hi);
            return;
        }

        int mid = (hi - lo) / 2 + lo;
        doSort(dest, src, lo, mid);
        doSort(dest, src, mid + 1, hi);
        if (less(src[mid + 1], src[mid])) {
            merge(src, dest, lo, mid, hi);
        }
    }

    //插入排序
    private void insertionSort(Comparable[] array, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(array[j], array[j - 1]); j--) {
                exch(array, j, j - 1);
            }
        }
    }

    private void merge(Comparable[] src, Comparable[] dest, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                dest[k] = src[j++];
            } else if (j > hi) {
                dest[k] = src[i++];
            } else if (less(src[i], src[j])) {
                dest[k] = src[i++];
            } else {
                dest[k] = src[j++];
            }
        }
    }

}
