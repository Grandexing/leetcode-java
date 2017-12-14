package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by grande on 2017/10/16.
 */
public class Q189RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution1(nums, 3);
        for (int i : nums) {
            System.out.println(i);
        }
    }


    public static void solution2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int current = i;
            int provVal = nums[current];
            do {
                int next = (current + k) % nums.length;
                int tmp = nums[next];
                nums[next] = provVal;
                current = next;
                provVal = tmp;
                count++;
            } while (current != i);
        }
    }


    public static void solution1(int[] nums, int k) {
        int[] tmps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmps[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int it = (k + i) % nums.length;
            System.out.println(it);
            nums[it] = tmps[i];
        }
    }
}
