package lintcode;

public class Q532ReversePairs {
//    http://www.lintcode.com/en/problem/reverse-pairs/

    private int[] tmp;
    public long reversePairs(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        tmp = new int[A.length];
        return mergeSort(A, 0, A.length - 1);
    }


    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int middle = start + (end - start) / 2;
        int sum = 0;
        sum += mergeSort(nums, start, middle);
        sum += mergeSort(nums, middle + 1, end);
        sum += merge(nums, start, middle, end);
        return sum;
    }


    private int merge(int[] nums, int start, int middle, int end) {
        int sum = 0;
        int left = start;
        int right = middle + 1;
        int index = start;
        while (left <= middle && right <= end) {
            if (nums[right] < nums[left]) {
                // 如果right < left, right 和 left 及 left 之后的左数组元素都构成一个逆序对
                // 总数是 middle - left + 1
                tmp[index++] = nums[right++];
                sum += middle - left + 1;
            } else {
                tmp[index++] = nums[left++];
            }
        }
        while (left <= middle) {
            tmp[index++] = nums[left++];
        }
        while (right <= end) {
            tmp[index++] = nums[right++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = tmp[i];
        }
        return sum;
    }
}
