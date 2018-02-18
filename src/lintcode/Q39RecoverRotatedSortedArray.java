package lintcode;

import java.util.ArrayList;
import java.util.List;

public class Q39RecoverRotatedSortedArray {
//    http://www.lintcode.com/en/problem/recover-rotated-sorted-array/#

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        List<Integer> nums = new ArrayList<>();
        for (int i : a
             ) {
            nums.add(i);
        }
        Q39RecoverRotatedSortedArray q39RecoverRotatedSortedArray = new Q39RecoverRotatedSortedArray();
        q39RecoverRotatedSortedArray.recoverRotatedSortedArray(nums);
        System.out.println(nums);
    }

    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() <= 1) {
            return;
        }
        // which also equals to the offset
        int indexOfMin = findMinIndex(nums);
        System.out.println(indexOfMin);
        int start = 0;
        int end = nums.size() - 1;
        rotate(nums, start, indexOfMin - 1);
        rotate(nums, indexOfMin, end);
        rotate(nums, start, end);
    }


    private void rotate(List<Integer> nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }


    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }


    private int findMinIndex(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return i;
            }
        }
        return -1;
    }
}
