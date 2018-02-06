package sword2offer;

public class Q56Part1 {
// 面试题56（一）：数组中只出现一次的两个数字
// 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
// 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (checkInvalid(array) || checkInvalid(num1) || checkInvalid(num2)) return;
        int resultOr = 0;
        for (int i = 0; i < array.length; i++) {
            resultOr ^= array[i];
        }
        int firstBit1 = findFirstBit1(resultOr);
        num1[0] = 0;
        num2[0] = 0;
        for (int j = 0; j < array.length; j++) {
            if (isBit1(array[j], firstBit1)) {
                num1[0] = num1[0] ^ array[j];
            } else {
                num2[0] = num2[0] ^ array[j];
            }
        }
    }


    int findFirstBit1(int num) {
        int index = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            index++;
        }
        return index;
    }


    boolean isBit1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }


    boolean checkInvalid(int[] array) {
        return array == null || array.length == 0;
    }
}
