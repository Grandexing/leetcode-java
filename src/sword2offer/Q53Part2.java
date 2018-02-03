package sword2offer;

public class Q53Part2 {
    public static void main(String[] args) {
        Q53Part2 q53Part2 = new Q53Part2();
        q53Part2.test();
    }


    int GetMissingNumber(int[] numbers) {
        int result = -1;
        if (numbers != null && numbers.length != 0) {
            int start = 0;
            int end = numbers.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (numbers[mid] != mid) {
                    if ((mid - 1 > 0 && numbers[mid - 1] == mid - 1) || mid == 0) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    start = mid + 1;
                }
            }
            if (start == end) {
                result = numbers.length;
            }
        }
        System.out.println(result);
        return result;
    }


    void Test(String testName, int numbers[], int expected)
    {
        if(testName != null)
            System.out.println("%s begins: "+testName);

        int result = GetMissingNumber(numbers);
        if(result == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("Failed.\n");
    }

    

    // 缺失的是第一个数字0
    void Test1()
    {
        int numbers[] = { 1, 2, 3, 4, 5 };
        int expected = 0;
        Test("Test1", numbers, expected);
    }

    // 缺失的是最后一个数字
    void Test2()
    {
        int numbers[] = { 0, 1, 2, 3, 4 };
        int expected = 5;
        Test("Test2", numbers, expected);
    }

    // 缺失的是中间某个数字0
    void Test3()
    {
        int numbers[] = { 0, 1, 2, 4, 5 };
        int expected = 3;
        Test("Test3", numbers, expected);
    }

    // 数组中只有一个数字，缺失的是第一个数字0
    void Test4()
    {
        int numbers[] = { 1 };
        int expected = 0;
        Test("Test4", numbers, expected);
    }

    // 数组中只有一个数字，缺失的是最后一个数字1
    void Test5()
    {
        int numbers[] = { 0 };
        int expected = 1;
        Test("Test5", numbers, expected);
    }

    // 空数组
    void Test6()
    {
        int expected = -1;
        Test("Test6", null, expected);
    }

    void test()
    {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
    }
}
