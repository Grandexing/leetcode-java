package sword2offer;

public class Q44 {
//    leecode 400
    public static void main(String[] args) {
        Q44 q44 = new Q44();
        q44.test();
    }


    public int digitAtIndex(int n) {
        if (n < 0) return -1;
        int digit = 1;
        while (true) {
            long number = numberOfDigit(digit);
            if (n < number * digit) {
                break;
            }
            n -= number * digit;
            digit++;
        }
        return findNthDigit(n, digit);
    }


    long numberOfDigit(int digit) {
        if (digit == 1) return 10;
        return 9 * (int) Math.pow(10, digit - 1);
    }


    int findNthDigit(int n, int digit) {
        int beginNumber = beginOfDigit(digit);
        int number = beginNumber + n / digit;
        int digitFromRight = digit - n % digit;
        for (int i = 1; i < digitFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }


    int beginOfDigit(int digit) {
        if (digit == 1) return 0;
        return (int) Math.pow(10, digit - 1);
    }


    void test(String testName, int inputIndex, int expectedOutput)
    {
        int actural = digitAtIndex(inputIndex);
        if(actural == expectedOutput) {
//            System.out.println(testName);
//            System.out.println("test input: " + inputIndex);
//            System.out.println("expected output: " + expectedOutput);
//            System.out.println("actual output: " + actural);
//            System.out.println(testName + " passed.");
        } else {
            System.out.println(testName);
            System.out.println("test input: " + inputIndex);
            System.out.println("expected output: " + expectedOutput);
            System.out.println("actual output: " + actural);
            System.out.println(testName + " FAILED.");
        }
    }


    void test()
    {
        test("Test1", 0, 0);
        test("Test2", 1, 1);
        test("Test3", 9, 9);
        test("Test4", 10, 1);
        test("Test5", 189, 9);  // 数字99的最后一位，9
        test("Test6", 190, 1);  // 数字100的第一位，1
        test("Test7", 1000, 3); // 数字370的第一位，3
        test("Test8", 1001, 7); // 数字370的第二位，7
        test("Test9", 1002, 0); // 数字370的第三位，0
    }
}
