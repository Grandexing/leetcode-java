package aljs4j.sort;

import static aljs4j.sort.Sort.exch;
import static aljs4j.sort.Sort.less;

/**
 * Created by grande on 2018/1/29.
 */
public class SelectionSort {
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
}
