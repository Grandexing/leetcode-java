package aljs4j.sort;

import java.sql.Timestamp;

import static aljs4j.sort.Sort.swap;
import static aljs4j.sort.Sort.less;

/**
 * Created by grande on 2018/1/29.
 */
public class ShellSort {
    public static void sort(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            //每次完成 h 间隔的子数组插入排序
            for (int i = 0; i < N; i += h) {
                int key = a[i];
                int j = i - h;
                while (j > 0 && a[j] > key) {
                    a[j + h] = a[j];
                    j -= h;
                }
                a[j + h] = key;
            }
            h = h / 3;
        }
    }
}
