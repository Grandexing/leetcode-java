package sword2offer;

import java.util.ArrayList;

public class Q57Part2 {
// 面试题57（二）：为s的连续正数序列
// 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
// 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
// 4～6和7～8。


    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3) return result;
        int small = 1;
        int big = 2;
        int curSum = small + big;
        int middle = (sum + 1) / 2;
        while (small < middle) {
            if (curSum == sum) {
                result.add(getResult(small, big));
            }
            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    result.add(getResult(small, big));
                }
            }
            big++;
            curSum += big;
        }
        return result;
    }


    ArrayList<Integer> getResult(int small, int big) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            result.add(i);
        }
        return result;
    }
}
