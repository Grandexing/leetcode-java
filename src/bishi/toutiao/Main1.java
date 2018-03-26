package bishi.toutiao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int result = findPairs(array, k);
        System.out.println(result);
    }


    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        int i = len - 1;
        int j = len - 1;

        while (i >= 0 && j >= 0) {
            while (i != len - 1 && i >= 0 && nums[i] == nums[i + 1]) {
                i--;
            }
            while (j != len - 1 && j >= 0 && nums[j] == nums[j + 1]) {
                j--;
            }
            if (i >= 0 && j >= 0) {
                int sub = nums[j] - nums[i];
                if (sub == k) {
                    count++;
                    i--;
                    j--;
                } else if (sub > k) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        return count;
    }
}
//5 2
//1 5 3 4 2

//6 2
//1 5 3 3 4 2

/*
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        if (n <= 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(nums);
        int i = n - 1;
        int j = n - 1;
        int count = 0;

        while (i >= 0 && j >= 0) {
            while (i != n - 1 && i >= 0 && nums[i] == nums[i + 1]) {
                i--;
            }

            while (j != n - 1 && j >= 0 && nums[j] == nums[j + 1]) {
                j--;
            }

            if (i >= 0 && j >= 0) {
                int target = nums[j] - nums[i];
                if (target == k) {
                    count++;
                    i--;
                    j--;
                } else if (target > k) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        System.out.println(count);
    }
}
 */