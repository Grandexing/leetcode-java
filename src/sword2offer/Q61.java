package sword2offer;

import java.util.Arrays;

public class Q61 {

// 面试题61：扑克牌的顺子
// 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。

    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) return false;
        //排序
        Arrays.sort(numbers);
        //统计 0 的个数
        int zeroCount = 0;
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            zeroCount++;
        }
        //统计数字间间隔的数量，如果发现连对，返回 false
        int small = zeroCount;
        int big = small + 1;
        int countOfGap = 0;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                //出现连对，不可能是顺子
                return false;
            }
            //差为 1 时，是连续的，即合理的顺子
            countOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        //间隔的总量小于 0 的个数，可以组成顺子
        return countOfGap <= zeroCount;
    }
}
