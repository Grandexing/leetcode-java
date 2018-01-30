package aljs4j.sort;

import java.util.Random;

public class QuickSort {
    static Random random;


    public static void sort(int[] a) {
        random = new Random();
        sort(a, 0, a.length - 1);
    }


    static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition1(a, lo, hi);//切分
        sort(a, lo, j - 1);//将 j 左半边排序
        sort(a, j + 1, hi);//将 j 右半边排序
    }


    static int partition1(int[] array, int lo, int hi) {
        if (lo >= hi) return lo;
//        剑指offer上的partition函数
        int j = random.nextInt(hi - lo + 1) + lo;
        swap(array, j, hi);
        int small = lo - 1;
        for (int i = lo; i < hi; i++) {
            if (array[i] < array[hi]) {
                small++;
                if (small != i) {
                    swap(array, small, i);
                }
            }
        }
        small++;
        swap(array, small, hi);
        return small;
    }

    static int partition(int[] a, int lo, int hi) {
//        定义左右扫描指针
        int i = lo;
        int j = hi;
//        切分元素
        int v = a[lo];
        while (i < j) {
            while (a[i] <= v && i < hi) {
                i++;
            }
            while (a[j] >= v && j > lo) {
                j--;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }


    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
