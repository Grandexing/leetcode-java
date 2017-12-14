package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by grande on 2017/12/13.
 */
public class Q167TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 7, 11, 15};
        int target = 9;
        int[] result = solution2(numbers, target);
        for (int r : result) {
            System.out.println(r);
        }
    }

//  binary search
    static int[] solution2(int[] numbers, int target) {
        int[] nums = new int[2];
        for (int i = 0;i < numbers.length;i++) {
            int l = i + 1;
            int r = numbers.length - 1;
            int tmp = target - numbers[i];
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(numbers[mid] == tmp){
                    return new int[]{i + 1, mid + 1};
                }
                if(numbers[mid] > tmp) r = mid - 1;
                else l = mid + 1;
            }
        }
        return nums;
    }


    public static int[] solution(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        while ((sum = numbers[left] + numbers[right]) != target) {
            if (sum < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[] {left + 1, right + 1};
    }

//    use hashmap
    static int[] solution1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = new int[2];
        for (int i = 0;i < numbers.length; i++){
            if (map.containsKey(target - numbers[i])){
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return nums;
    }

}
