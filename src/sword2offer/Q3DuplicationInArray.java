package sword2offer;

public class Q3DuplicationInArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate1(nums));
        System.out.println(duplicate2(nums));
    }


//    2. 不修改数组找出重复的数字（任意一个）
    public static int duplicate2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int middle = (end - start) / 2 + start;
            int count = countRange(nums, start, middle);
            if (end == start) {
                if (count > 1) return start;
                else break;
            }
            if (count > middle - start + 1) end = middle - 1;
            else start = middle + 1;
        }
        return -1;
    }


    public static int countRange(int[] nums, int start, int end) {
        if (nums == null) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) count++;
        }
        return count;
    }

//    1. 数组中重复的数字
    public static boolean duplicate1(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        for (int num : nums) {
            if (num < 0 || num > nums.length + 1) return false;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) return true;
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return false;
    }
}
