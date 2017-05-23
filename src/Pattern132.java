/**
 * Created by grande-xing on 2017/5/23.
 */
public class Pattern132 {
    public static boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (length<3) return false;
        int index = 0;
        for (int i = 0; i < length-2; i++) {
            for (int j = i+1; j < length-1; j++) {
                if (nums[j]>nums[i]){
                    for (int k = j+1; k < length; k++) {
                        if (nums[k]>nums[i] && nums[k]<nums[j]) return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(find132pattern(nums));
    }
}
