/**
 * Created by grande on 2017/5/22.
 */
public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int min = nums[0];
        int minPos = 0;
        int max = nums[0];
        int maxPos = 0;
        int index = 0;
        int start = 0;
        int end = 0;
        while (index < length){
            if (nums[index] <= max){
                start = index - 1;
                if (nums[index] < min) min = nums[index];
            } else max = nums[index];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 2, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }
}
