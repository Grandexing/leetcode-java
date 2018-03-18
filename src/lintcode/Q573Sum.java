package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q573Sum {
//    http://www.lintcode.com/en/problem/3sum/

    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int target = -numbers[i];
            twoSum(numbers, i + 1, numbers.length - 1, target, result);
        }
        return result;
    }


    private void twoSum(int[] nums, int left, int right, int target,
                        List<List<Integer>> result) {
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> tripple = new ArrayList<>();
                tripple.add(-target);
                tripple.add(nums[left]);
                tripple.add(nums[right]);
                result.add(tripple);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
