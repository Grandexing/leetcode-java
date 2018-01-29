package aljs4j.sort;

import static aljs4j.sort.Sort.swap;

/**
 * Created by grande on 2018/1/29.
 */
public class InsertionSort {


    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
    }
}
