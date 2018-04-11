package bishi.xinyongka;

import java.util.*;

public class Main1 {
    static class Pair {
        int val;
        int abs;
        Pair(int val, int abs) {
            this.val = val;
            this.abs = abs;
        }
    }

    static Comparator<Pair> cmp = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.abs != o2.abs) {
                return o2.abs - o1.abs;
            } else {
                return o2.val - o1.val;
            }
        }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] field = line.split(" ");
        int[] data = new int[field.length];
        for (int i = 0; i < field.length; i++) {
            data[i] = Integer.parseInt(field[i]);
        }
        line = scanner.nextLine();
        field = line.split(" ");
        int n = data.length;
        int x = Integer.parseInt(field[0]);
        int k = Integer.parseInt(field[1]);
        int left = 0;
        int right = n - 1;
        int index = -1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == x) {
                index = mid;
                break;
            } else if (data[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (index == -1) {
            index = Math.abs(data[left] - x) <= Math.abs(data[right] - x) ? left : right;
        }
        int count = 0;
        left = index - 1;
        right = index + 1;
        int[] ans = new int[k];
        while (count < k) {
//            System.out.print(data[index]);
            ans[count] = data[index];
//            if (count != k - 1) {
//                System.out.print(" ");
//            }
            count++;
            if (left >= 0 && right < n) {
                if (x - data[left] <= data[right] - x) {
                    index = left;
                    left--;
                } else {
                    index = right;
                    right++;
                }
            } else if (left >= 0) {
                index = left;
                left--;
            } else {
                index = right;
                right++;
            }
        }
        Arrays.sort(ans);
        for (int i = 0; i < k; i++) {
            System.out.print(ans[i]);
            if (i != k - 1) {
                System.out.print(" ");
            }
        }
    }
}
/*
1 2 3 4 5
3 4
 */