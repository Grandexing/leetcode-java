package sword2offer;

public class Q42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        //无效输入与和确实为0的区分方法：抛异常或者用全局 flag 表示
        if (array == null || array.length == 0) return 0;
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}
