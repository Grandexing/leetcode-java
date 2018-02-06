package sword2offer;

public class Q53Part3 {
// 面试题53（三）：数组中数值和下标相等的元素
// 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
// 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1,
// 1, 3, 5}中，数字3和它的下标相等。
    public static void main(String[] args) {
        Q53Part3 q53Part3 = new Q53Part3();
        q53Part3.test();
    }

    
    public int getNumberSameAsIndex(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (numbers[mid] == mid) {
                return mid;
            }
            if (numbers[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    void Test(String testName, int numbers[], int expected)
    {
        if(getNumberSameAsIndex(numbers) == expected)
            System.out.println(String.format("%s passed.\n", testName));
        else
            System.out.println(String.format("%s FAILED.\n", testName));
    }

    void Test1()
    {
        int numbers[] = { -3, -1, 1, 3, 5 };
        int expected = 3;
        Test("Test1", numbers, expected);
    }

    void Test2()
    {
        int numbers[] = { 0, 1, 3, 5, 6 };
        int expected = 0;
        Test("Test2", numbers, expected);
    }

    void Test3()
    {
        int numbers[] = { -1, 0, 1, 2, 4 };
        int expected = 4;
        Test("Test3", numbers, expected);
    }

    void Test4()
    {
        int numbers[] = { -1, 0, 1, 2, 5 };
        int expected = -1;
        Test("Test4", numbers, expected);
    }

    void Test5()
    {
        int numbers[] = { 0 };
        int expected = 0;
        Test("Test5", numbers, expected);
    }

    void Test6()
    {
        int numbers[] = { 10 };
        int expected = -1;
        Test("Test6", numbers, expected);
    }

    void Test7()
    {
        Test("Test7", null, -1);
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
    }

}
