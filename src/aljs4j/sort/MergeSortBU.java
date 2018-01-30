package aljs4j.sort;

import static aljs4j.sort.Sort.less;

/**
 * Created by grande on 2018/1/29.
 */
public class MergeSortBU {
    //自顶向下的归并排序
    static int[] aux;


    public static void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }


    static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        //排序左半边
        sort(a, lo, mid);
        //排序右半边
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }


    static void merge(int[] a, int lo, int mid, int hi) {
        //将数据复制到辅助数组中
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        //得到左右两个数组的起点
        int i = lo;
        int j = mid + 1;
        //将左右两个有序数组归并为一个数组
        for (int k = lo; k <= hi; k++) {
            //左边数组耗尽，这一步是否有必要？
            if (i > mid) {
                a[k] = aux[j];
                j++;
            }
            //右边数组耗尽
            else if (j > hi) {
                a[k] = aux[i];
                i++;
            }
            //右边小于左边，用右边
            else if (aux[j] < aux[i]) {
                a[k] = aux[j];
                j++;
            }
            //左边小于等于右边，用左边
            else {
                a[k] = aux[i];
                i++;
            }
        }
    }
}