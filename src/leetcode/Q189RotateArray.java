package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by grande on 2017/10/16.
 */
public class Q189RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        solution4(nums, 3);
        show(nums);
    }


    public static void solution4(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        //find GCD between nums length and step
        int gcd = findGcd(nums.length, step);
        int position, count;

        //gcd path to finish movie
        for(int i = 0; i < gcd; i++){
            //beginning position of each path
            position = i;
            //count is the number we need swap each path
            count = nums.length / gcd - 1;
            for(int j = 0; j < count; j++){
                position = (position + step) % nums.length;
                //swap index value in index i and position
                nums[i] ^= nums[position];
                nums[position] ^= nums[i];
                nums[i] ^= nums[position];
            }
            show(nums);
        }
    }


    public static int findGcd(int a, int b){
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
    }


    public static void solution3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }


    static void reverse(int[] nums, int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
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


    static void show(int[] nums){
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
