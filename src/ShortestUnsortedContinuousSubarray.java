import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by grande on 2017/5/22.
 */
public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int[] sorted = Arrays.copyOf(nums,length);
        Arrays.sort(sorted);
        int start = 0;
        int end = length-1;
        while (start<length){
           if (nums[start]!= sorted[start]) break;
           start++;
        }
        while (end>-1){
            if (nums[end] != sorted[end]) break;
            end--;
        }
        return end-start>0?end-start+1:0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
//        int[] nums = {3,1,2,4,5};
        System.out.println(findUnsortedSubarray(nums));
    }
}
