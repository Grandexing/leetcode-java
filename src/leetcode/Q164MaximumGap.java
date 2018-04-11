package leetcode;

import java.util.Arrays;

public class Q164MaximumGap {
//    https://leetcode.com/problems/maximum-gap/description/

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int item : nums) {
            maxNum = Math.max(maxNum, item);
            minNum = Math.min(minNum, item);
        }
        if (minNum == maxNum) {
            return 0;
        }
//         确定每个桶的大小，防止 0 值
        int gap = Math.max(1, (maxNum - minNum) / (nums.length - 1));
//         桶的个数
        int numOfBucket = (maxNum - minNum) / gap + 1;
        int[] minBucket = new int[numOfBucket];
        int[] maxBucket = new int[numOfBucket];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        for (int item : nums) {
            int index = (item - minNum) / gap;
            minBucket[index] = Math.min(minBucket[index], item);
            maxBucket[index] = Math.max(maxBucket[index], item);
        }
        int maxGap = Integer.MIN_VALUE;
        int pre = maxBucket[0];
        for (int i = 0; i < numOfBucket; i++) {
            if (minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE) {
                continue;
            } else {
                maxGap = Math.max(maxGap, minBucket[i] - pre);
                pre = maxBucket[i];
            }
        }
        return maxGap;
    }


    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
//         radix sort
//         find max
        int max = Integer.MIN_VALUE;
        for (int item : nums) {
            max = Math.max(item, max);
        }
        int n = nums.length;
        int radix = 10;
        int exp = 1;
        int[] aux = new int[n];
        int[] count = new int[radix];
        int k;
        while (max / exp > 0) {
            Arrays.fill(count, 0);
            for (int i : nums) {
                k = (i / exp) % 10;
                count[k]++;
            }
            for (int i = 1; i < radix; i++) {
                count[i] += count[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                k = (nums[i] / exp) % 10;
                aux[count[k] - 1] = nums[i];
                count[k]--;
            }
            for (int i = 0; i < n; i++) {
                nums[i] = aux[i];
            }
            exp *= 10;
        }
//         find max gap
        int maxGap = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }
}
