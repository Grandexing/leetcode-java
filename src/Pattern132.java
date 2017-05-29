import java.util.HashSet;

/**
 * Created by grande-xing on 2017/5/23.
 */
public class Pattern132 {
    public static boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (length < 3) return false;
        HashSet set = new HashSet();
        for (int i = 0; i < length - 2; i++) {
            if (!set.contains(i)) {
                for (int j = i + 1; j < length - 1; j++) {
                    if (nums[j] - nums[i] > 1) {
                        for (int k = j + 1; k < length; k++) {
                            if (nums[k] > nums[i] && nums[k] < nums[j]) return true;
                        }
                    }
                }
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static boolean find132patternV2(int[] nums) {
        int length = nums.length;
        int i = 0;
        while (i < length - 2) {
            int min = nums[i];
            int max = min;
            for (int j = i + 1; j < length - 1; j++) {
                if (nums[j] > max) max = nums[j];
                else if (nums[j] < max) return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        System.out.println(find132patternV2(nums));
    }
}
