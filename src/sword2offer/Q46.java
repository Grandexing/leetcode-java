package sword2offer;

public class Q46 {
    public static void main(String[] args) {
        Q46 q46 = new Q46();
        q46.test();
    }


    public int getTranslationCount(int number) {
        if (number < 0) return 0;
        char[] numberStr = String.valueOf(number).toCharArray();
        return getTranslationCount(numberStr);
    }


    private int getTranslationCount(char[] cs) {
        int length = cs.length;
        int count = 0;
        int[] counts = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            count = 1;
            if (i < length - 1) {
//                非末位，初始count等于前一位的count
                count = counts[i + 1];
//                非末位，还要考虑两个数字的情况
                int digit1 = cs[i] - '0';
                int digit2 = cs[i + 1] - '0';
                int num = digit1 * 10 + digit2;
                if (10 <= num && num <= 25) {
                    if (i < length - 2) {
                        count += counts[i + 2];
                    } else {
                        count++;
                    }
                }
            }
            counts[i] = count;
        }
        count = counts[0];
        return count;
    }


    void Test(String testName, int number, int expected)
    {
        if(getTranslationCount(number) == expected){
            System.out.println(testName + " passed.");
        }
        else {
            System.out.println(testName + " FAILED.");
        }
    }

    void Test1()
    {
        int number = 0;
        int expected = 1;
        Test("Test1", number, expected);
    }

    void Test2()
    {
        int number = 10;
        int expected = 2;
        Test("Test2", number, expected);
    }

    void Test3()
    {
        int number = 125;
        int expected = 3;
        Test("Test3", number, expected);
    }

    void Test4()
    {
        int number = 126;
        int expected = 2;
        Test("Test4", number, expected);
    }

    void Test5()
    {
        int number = 426;
        int expected = 1;
        Test("Test5", number, expected);
    }

    void Test6()
    {
        int number = 100;
        int expected = 2;
        Test("Test6", number, expected);
    }

    void Test7()
    {
        int number = 101;
        int expected = 2;
        Test("Test7", number, expected);
    }

    void Test8()
    {
        int number = 12258;
        int expected = 5;
        Test("Test8", number, expected);
    }

    void Test9()
    {
        int number = -100;
        int expected = 0;
        Test("Test9", number, expected);
    }

    void test() {
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
