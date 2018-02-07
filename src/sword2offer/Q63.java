package sword2offer;

public class Q63 {
// 面试题63：股票的最大利润
// 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股
// 票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,
// 7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能
// 收获最大的利润11。

    public static void main(String[] args) {
        Q63 q63 = new Q63();
        q63.test();
    }


    int maxDiff(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return 0;
        }
        int min = numbers[0];
        int maxDiff = numbers[1] - min;
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i - 1] < min) {
                min = numbers[i - 1];
            }
            int curDiff = numbers[i] - min;
            if (curDiff > maxDiff) {
                maxDiff = curDiff;
            }
        }
        return maxDiff;
    }


    // ==================== Test Code ====================
    void Test(String testName, int[] numbers, int expected)
    {
        if(testName != null)
            System.out.println(String.format("%s begins: ", testName));

        if(maxDiff(numbers) == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("FAILED.\n");
    }

    void Test1()
    {
        int numbers[] = { 4, 1, 3, 2, 5 };
        Test("Test1", numbers, 4);
    }

    // 价格递增
    void Test2()
    {
        int numbers[] = { 1, 2, 4, 7, 11, 16 };
        Test("Test2", numbers, 15);
    }

    // 价格递减
    void Test3()
    {
        int numbers[] = { 16, 11, 7, 4, 2, 1 };
        Test("Test3", numbers, -1);
    }

    // 价格全部相同
    void Test4()
    {
        int numbers[] = { 16, 16, 16, 16, 16 };
        Test("Test4", numbers, 0);
    }

    void Test5()
    {
        int numbers[] = { 9, 11, 5, 7, 16, 1, 4, 2 };
        Test("Test5", numbers, 11);
    }

    void Test6()
    {
        int numbers[] = { 2, 4 };
        Test("Test6", numbers, 2);
    }

    void Test7()
    {
        int numbers[] = { 4, 2 };
        Test("Test7", numbers, -2);
    }

    void Test8()
    {
        Test("Test8", null, 0);
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
    }
}
