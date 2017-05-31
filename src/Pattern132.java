import java.util.HashSet;

/**
 * Created by grande-xing on 2017/5/23.
 */
public class Pattern132 {
    public static boolean find132pattern(int[] nums) {
        int length = nums.length;
        for (int j = 0,min = Integer.MAX_VALUE; j < length - 1; j++) {
            min = Integer.min(nums[j], min);
            if (min == nums[j]) continue;
            for (int k = j+1; k < length; k++) {
                if (min < nums[k] && nums[k] < nums[j]) return true;
            }
        }
        return false;
    }

    public static boolean find132patternV2(int[] nums) {
        int length = nums.length;
        for (int j = 0,min = Integer.MAX_VALUE; j < length - 1; j++) {
            min = Integer.min(nums[j], min);
            if (min == nums[j]) continue;
            for (int k = length - 1; k > j; k--) {
                if (min < nums[k] && nums[k] < nums[j]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        System.out.println(find132pattern(nums));
    }
}
