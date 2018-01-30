package aljs4j.sort;

public class QuickSort {
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }


    static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);//切分
        sort(a, lo, j - 1);//将 j 左半边排序
        sort(a, j + 1, hi);//将 j 右半边排序
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
