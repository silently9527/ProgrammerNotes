package cn.silently9527.sort;

/**
 * 归并排序
 */
public class MergeSort implements SortTemplate {
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        aux = new Comparable[length];
        for (int sz = 1; sz < length; sz += sz) {
            for (int i = 0; i < length - sz; i += 2 * sz) {
                merge(array, i, i + sz - 1, Math.min(i + 2 * sz - 1, length - 1));
            }
        }
    }

    private void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

}
