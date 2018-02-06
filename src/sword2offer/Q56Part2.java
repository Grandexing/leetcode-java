package sword2offer;

public class Q56Part2 {

// 面试题56（二）：数组中唯一只出现一次的数字
// 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
// 找出那个吃出现一次的数字。


    public static void main(String[] args) {
        Q56Part2 q56Part2 = new Q56Part2();
        q56Part2.test();
    }


    public int findNumberAppearingOnce(int[] numbers) {
//        整型共32位，本解法时间复杂度 O(n)，空间复杂度 O(1)
//        如果出现三次，bitSum中相应位置的数可以被3整除
        int[] bitSum = new int[32];
        for (int i = 0; i < numbers.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = numbers[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < bitSum.length; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }
    

    // ====================测试代码====================
    void Test(String testName, int numbers[], int expected)
    {
        int result = findNumberAppearingOnce(numbers);
        if(result == expected)
            System.out.println(String.format("%s passed.\n", testName));
        else
            System.out.println(String.format("%s FAILED.\n", testName));
    }

    // 所有数字都是正数，唯一的数字是最小的
    void Test1()
    {
        int numbers[] = { 1, 1, 2, 2, 2, 1, 3 };
        int expected = 3;
        Test("Test1", numbers,  expected);
    }

    // 所有数字都是正数，唯一的数字的大小位于中间
    void Test2()
    {
        int numbers[] = { 4, 3, 3, 2, 2, 2, 3 };
        int expected = 4;
        Test("Test2", numbers,  expected);
    }

    // 所有数字都是正数，唯一的数字是最大的
    void Test3()
    {
        int numbers[] = { 4, 4, 1, 1, 1, 7, 4 };
        int expected = 7;
        Test("Test3", numbers,  expected);
    }

    // 唯一的数字是负数
    void Test4()
    {
        int numbers[] = { -10, 214, 214, 214 };
        int expected = -10;
        Test("Test4", numbers,  expected);
    }

    // 除了唯一的数字，其他数字都是负数
    void Test5()
    {
        int numbers[] = { -209, 3467, -209, -209 };
        int expected = 3467;
        Test("Test5", numbers,  expected);
    }

    // 重复的数字有正数也有负数
    void Test6()
    {
        int numbers[] = { 1024, -1025, 1024, -1025, 1024, -1025, 1023 };
        int expected = 1023;
        Test("Test6", numbers,  expected);
    }

    // 所有数字都是负数
    void Test7()
    {
        int numbers[] = { -1024, -1024, -1024, -1023 };
        int expected = -1023;
        Test("Test7", numbers,  expected);
    }

    // 唯一的数字是0
    void Test8()
    {
        int numbers[] = { -23, 0, 214, -23, 214, -23, 214 };
        int expected = 0;
        Test("Test8", numbers,  expected);
    }

    // 除了唯一的数字，其他数字都是0
    void Test9()
    {
        int numbers[] = { 0, 3467, 0, 0, 0, 0, 0, 0 };
        int expected = 3467;
        Test("Test9", numbers,  expected);
    }

    void test()
    {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
        Test8();
        Test9();

    }
}
