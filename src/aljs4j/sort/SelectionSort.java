package aljs4j.sort;

import static aljs4j.sort.Sort.swap;

/**
 * Created by grande on 2018/1/29.
 */
public class SelectionSort {
    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
        	int min = i;
        	for (int j = i + 1; j < N; j++) {
        		if (a[j] < a[min]) {
        		    min = j;
        		}
        	}
        	swap(a, i, min);
        }
    }
}
