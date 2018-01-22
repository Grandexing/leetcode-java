package sword2offer;

import static sword2offer.Q17.Print1ToMaxOfNDigits_1;
import static sword2offer.Q17.Print1ToMaxOfNDigits_2;

public class Q17 {
    public static void main(String[] args) {
        Print1ToMaxOfNDigits_1(1);
//        printNumber("00000123".toCharArray());
//        Test4Q17 test = new Test4Q17();
//        test.Test(2);
//        test.Test(3);
//        test.Test(0);
//        test.Test(-1);
    }


    static void Print1ToMaxOfNDigits_1(int n) {
        if (n <= 0) return;
        char[] number = new char[n + 1];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        while (!increment(number)) {
            printNumber(number);
        }
    }


    static void Print1ToMaxOfNDigits_2(int n) {

    }


    static boolean increment(char[] number) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int length = number.length;
        int nSum = 0;
        for (int i = length - 1; i >= 0; i--) {
            nSum = number[i] - '0' + nTakeOver;
            if (i == length - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) (nSum + '0');
                }
            } else {
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverflow;
    }

    static void printNumber(char[] number) {
        int i = 0;
        while (i < number.length && number[i] == '0') {
            i++;
        }
        while (i  < number.length) {
            System.out.print(number[i]);
            i++;
        }
        System.out.println();
    }
}

class Test4Q17 {
    void Test(int n)
    {
        System.out.println("Test for %d begins:\n");

        Print1ToMaxOfNDigits_1(n);
        Print1ToMaxOfNDigits_2(n);

        System.out.println("\nTest for %d ends.\n");
    }
}
