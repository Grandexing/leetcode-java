package aljs4j.sort;

import static aljs4j.sort.Sort.less;

/**
 * Created by grande on 2018/1/29.
 */
public class MergeSort {
    public static void mergeSortBU(int[] a) {
        int N = a.length;
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 1; lo < N - sz; lo = lo + sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }


    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }


    public static void mergeSort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }


    public static void merge(int[] a, int lo, int mid, int hi) {
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
            } else if (j > hi) {
                a[k] = aux[i];
                i++;
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j];
                j++;
            } else {
                a[k] = aux[i];
                i++;
            }
        }
    }

}
