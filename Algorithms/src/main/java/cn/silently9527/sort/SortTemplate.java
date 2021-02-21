package cn.silently9527.sort;

public interface SortTemplate {

    void sort(Comparable[] array);

    default void print(Comparable[] array) {
        for (Comparable a : array) {
            System.out.print(a + " ");
        }
    }

    default boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    default void exch(Comparable[] array, int i, int j) {
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
