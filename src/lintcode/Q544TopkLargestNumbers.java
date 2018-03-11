package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Q544TopkLargestNumbers {
    public int[] topk(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || k <= 0 || nums.length < k) {
            return null;
        }
        int[] out = new int[k];
        int pivot = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != pivot) {
            if (index < pivot) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(nums, start, end);
        }
        for (int i = index; i < nums.length; i++) {
            out[i - index] = nums[i];
        }
        Arrays.sort(out);
        return out;
    }


    private int partition(int[] nums, int start, int end) {
        if (start >= end) {
            return start;
        }
        int small = start - 1;
        int pivot = start + (end - start) / 2;
        swap(nums, pivot, end);
        for (int i = 0; i < end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                if (small != i) {
                    swap(nums, i, small);
                }
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }


    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
