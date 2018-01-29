package aljs4j.sort;

import static aljs4j.sort.Sort.exch;
import static aljs4j.sort.Sort.less;

/**
 * Created by grande on 2018/1/29.
 */
public class ShellSort {
    public static void shellSort(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
//        h:1,4,13,40....
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
