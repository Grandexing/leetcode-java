package bishi.toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    static ArrayList<Integer> result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        result = new ArrayList<>();
        search(n, 1, 1, 0);
        int[] nums = new int[result.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result.get(i);
        }
        Arrays.sort(nums);
        System.out.println(nums[0]);
    }

    public static void search(int n, int s, int m , int count) {
        if (n == s) {
            result.add(count);
            return;
        }
        if (n < s) {
            return;
        }
        search(n, s * 2, s, count + 1);
        search(n,s + m, m, count + 1);
    }
}