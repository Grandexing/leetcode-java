package bishi.toutiao;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] f1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(f1[0]);
        int m = Integer.parseInt(f1[1]);
        int[] a = new int[n];
        int[] b = new int[m];
//        TreeSet<Integer> a = new TreeSet<>();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        PriorityQueue<Integer> minHeapA = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeapA = new PriorityQueue<>(comparator);
        PriorityQueue<Integer> minHeapB = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeapB = new PriorityQueue<>(comparator);
        String[] f2 = scanner.nextLine().split(" ");
        int meanA = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(f2[i]);
            meanA += a[i];
        }
        meanA = meanA / n;
        String[] f3 = scanner.nextLine().split(" ");
        int meanB = 0;
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(f3[i]);
            meanB += b[i];
        }
        meanB /= m;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < meanA) {
                maxHeapA.add(a[i]);
            } else {
                minHeapA.add(a[i]);
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] < meanB) {
                maxHeapB.add(b[i]);
            } else {
                minHeapB.add(b[i]);
            }
        }
        int count = 0;
        while (n > 1 && m > 1) {
            if (meanA > meanB) {
                int num = maxHeapA.poll();
            }
        }
        System.out.println(count);
    }

    public static int magic(int[] a, int[] b, int meanA, int meanB) {

        return 0;
    }
}
