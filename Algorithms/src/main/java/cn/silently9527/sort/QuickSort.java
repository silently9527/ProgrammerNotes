package cn.silently9527.sort;

import java.util.Random;

public class QuickSort implements SortTemplate {
    @Override
    public void sort(Comparable[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Comparable[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        if (hi - lo < 5) {
            insertionSort(array, lo, hi);
            return;
        }

        int partition = partition(array, lo, hi);
        quickSort(array, lo, partition - 1);
        quickSort(array, partition + 1, hi);
    }

    //插入排序
    private void insertionSort(Comparable[] array, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(array[j], array[j - 1]); j--) {
                exch(array, j, j - 1);
            }
        }
    }

    private int partition(Comparable[] array, int lo, int hi) {
        int i = lo, j = hi + 1;
        int random = new Random().nextInt(hi - lo) + lo;
        exch(array, lo, random);
        Comparable el = array[lo];
        while (true) {
            while (less(array[++i], el)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(el, array[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(array, i, j);
        }
        exch(array, lo, j);
        return j;
    }

}
