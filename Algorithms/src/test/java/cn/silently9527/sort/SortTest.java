package cn.silently9527.sort;

import org.junit.Test;

public class SortTest {
    private Integer[] array = new Integer[]{67, 4, 6, 1, 67, 4, 7, 0, 12, 44, 5, 2, 32, 12, 32, 23, 4, 55, 67, 59, 3};

    @Test
    public void testSelectionSort() {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array);
        selectionSort.print(array);
    }

    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        bubbleSort.print(array);
    }

    @Test
    public void testInsertionSort() {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array);
        insertionSort.print(array);
    }

    @Test
    public void testShellSort() {
        ShellSort shellSort = new ShellSort();
        shellSort.sort(array);
        shellSort.print(array);
    }

    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        mergeSort.print(array);
    }

    @Test
    public void testMergeSort2() {
        MergeSort2 mergeSort = new MergeSort2();
        mergeSort.sort(array);
        mergeSort.print(array);
    }

    @Test
    public void testQuickSort() {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        quickSort.print(array);
    }
}