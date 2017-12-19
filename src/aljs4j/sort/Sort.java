package aljs4j.sort;

import java.lang.Math;

public class Sort {


    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 342, 3, 2, 4, 6, 10, 123, 1234, 321, 345};
        show(a);
        mergeSortBU(a);
        show(a);
        System.out.println(isSorted(a));
    }


    public static void mergeSortBU(int[] a) {
        int N = a.length;
        for (int sz = 1; sz < N; sz = sz + sz) {
        	for(int lo = 1; lo < N - sz; lo = lo + sz + sz) {
        		merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        	}
        }
    }


    public static void mergeSort(int[] a){
        mergeSort(a, 0, a.length - 1);
    }


    public static void mergeSort(int[] a, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }


    public static void merge(int[] a, int lo, int mid, int hi){
        int[] aux = new int[a.length];
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j];
                j++;
            }
            else if (j > hi) {
                a[k] = aux[i];
                i++;
            }
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j];
                j++;
            }
            else {
                a[k] = aux[i];
                i++;
            }
        }
    }


    public static void shellSort(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1;
//        h:1,4,13,40....
        while (h >= 1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
     }


    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }


    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    exch(a, j, j - 1);
                }
            }
        }
    }


    public static void insertionSortV2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j > 0 && a[j] > key){
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
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
