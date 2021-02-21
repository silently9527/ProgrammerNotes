package cn.silently9527.sort;

import org.junit.Test;

public class SortTest {
    private Integer[] array = new Integer[]{4, 6, 1, 4, 7, 0, 12, 44, 5, 2, 3};

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
}