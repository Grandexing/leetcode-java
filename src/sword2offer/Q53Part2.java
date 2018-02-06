package sword2offer;

public class Q53Part2 {

// 面试题53（二）：0到n-1中缺失的数字
// 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
// 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
// 中，请找出这个数字。


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
//                    如果值和下标不等
                    if ((mid - 1 > 0 && numbers[mid - 1] == mid - 1) || mid == 0) {
//                        这个值的是第一个值和下标不等的位置
                        return mid;
                    } else {
//                        第一个值和下标不等的值在当前mid的左边
                        end = mid - 1;
                    }
                } else {
//                    第一个值和下标不等的值在mid的右边
                    start = mid + 1;
                }
            }
            if (start >= end) {
                result = numbers.length;
            }
        }
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
