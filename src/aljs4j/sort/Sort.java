package aljs4j.sort;

import java.lang.Math;

public class Sort {


    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 342, 3, 2, 4, 6, 10, 123, 1234, 321, 345};
        show(a);
        MergeSort.mergeSortBU(a);
        show(a);
        System.out.println(isSorted(a));
    }


    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static boolean less(int a, int b) {
        return a < b;
    }


    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (!less(a[i - 1], a[i])) return false;
        }
        return true;
    }


    public static void show(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
