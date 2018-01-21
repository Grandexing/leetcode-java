package sword2offer;

import static sword2offer.Q14.maxProductAfterCutting_solution1;
import static sword2offer.Q14.maxProductAfterCutting_solution2;

public class Q14 {
    public static void main(String[] args) {
        Test test = new Test();
        test.test1();
        test.test2();
        test.test3();
        test.test4();
        test.test5();
        test.test6();
        test.test7();
        test.test8();
        test.test9();
        test.test10();
        test.test11();
    }


    public static int maxProductAfterCutting_solution1(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
            }
            products[i] = max;
        }
        max = products[length];
        return max;
    }


    public static int maxProductAfterCutting_solution2(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;
        int timesOf3 = length / 3;
//        处理有一段为4的情况，此时应该切为 2*2 而不是 3*1
        if (length - timesOf3 * 3 == 1) timesOf3--;
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }

}

class Test {
    void test(String testName, int length, int expected) {
        int result1 = maxProductAfterCutting_solution1(length);
        if (result1 == expected)
            System.out.println("Solution1 for " + testName + " passed.");
        else
            System.out.println("Solution1 for " + testName + " FAILED.");

        int result2 = maxProductAfterCutting_solution2(length);
        if (result2 == expected)
            System.out.println("Solution2 for " + testName + " passed.");
        else
            System.out.println("Solution2 for " + testName + " FAILED.");
    }

    void test1() {
        int length = 1;
        int expected = 0;
        test("test1", length, expected);
    }

    void test2() {
        int length = 2;
        int expected = 1;
        test("test2", length, expected);
    }

    void test3() {
        int length = 3;
        int expected = 2;
        test("test3", length, expected);
    }

    void test4() {
        int length = 4;
        int expected = 4;
        test("test4", length, expected);
    }

    void test5() {
        int length = 5;
        int expected = 6;
        test("test5", length, expected);
    }

    void test6() {
        int length = 6;
        int expected = 9;
        test("test6", length, expected);
    }

    void test7() {
        int length = 7;
        int expected = 12;
        test("test7", length, expected);
    }

    void test8() {
        int length = 8;
        int expected = 18;
        test("test8", length, expected);
    }

    void test9() {
        int length = 9;
        int expected = 27;
        test("test9", length, expected);
    }

    void test10() {
        int length = 10;
        int expected = 36;
        test("test10", length, expected);
    }

    void test11() {
        int length = 50;
        int expected = 86093442;
        test("test11", length, expected);
    }
}
