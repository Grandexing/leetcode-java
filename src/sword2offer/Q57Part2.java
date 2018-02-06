package sword2offer;

import java.util.ArrayList;

public class Q57Part2 {
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
