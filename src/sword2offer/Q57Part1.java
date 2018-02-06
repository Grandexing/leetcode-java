package sword2offer;

import java.util.ArrayList;

public class Q57Part1 {
// 面试题57（一）：和为s的两个数字
// 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们
// 的和正好是s。如果有多对数字的和等于s，输出任意一对即可。

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) return result;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int sumTemp = array[start] + array[end];
            if (sumTemp == sum) {
                break;
            }
            if (sumTemp < sum) {
                start++;
            } else {
                end--;
            }
        }
        if (start < end) {
            result.add(array[start]);
            result.add(array[end]);
        }
        return result;
    }
}
