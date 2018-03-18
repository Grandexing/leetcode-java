package lintcode;

public class Q143SortColorsII {
//    http://www.lintcode.com/en/problem/sort-colors-ii/

    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0 || k < 1) {
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }


    private void rainbowSort(int[] nums, int start, int end, int colorFrom, int colorTo) {
        if (colorFrom >= colorTo || start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int colorMiddle = colorFrom + (colorTo - colorFrom) / 2;
        while (left <= right) {
            while (left <= right && nums[left] <= colorMiddle) {
                left++;
            }
            while (left <= right && nums[right] > colorMiddle) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        rainbowSort(nums, start, right, colorFrom, colorMiddle);
        rainbowSort(nums, left, end, colorMiddle + 1, colorTo);
    }
}
