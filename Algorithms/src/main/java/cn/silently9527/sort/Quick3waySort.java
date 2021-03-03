package cn.silently9527.sort;

public class Quick3waySort implements SortTemplate {
    @Override
    public void sort(Comparable[] array) {
        quickSort(array, 0, array.length - 1);
    }

    @SuppressWarnings("unchecked")
    private void quickSort(Comparable[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        Comparable el = array[lo];
        while (i <= gt) {
            int tmp = el.compareTo(array[i]);
            if (tmp > 0) {
                exch(array, lt++, i++);
            } else if (tmp < 0) {
                exch(array, i, gt--);
            } else {
                i++;
            }
        }
        quickSort(array, lo, lt - 1);
        quickSort(array, gt + 1, hi);
    }
}
