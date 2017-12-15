package aljs4j.sort;

public class Sort {


    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 3, 2, 4, 6};
        show(a);
        insertionSort(a);
        show(a);
        System.out.println(isSorted(a));
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
