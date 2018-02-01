package leetcode;

/**
 * Created by grande on 2018/1/31.
 */
public class Q400NthDigit {
    public static void main(String[] args) {
        Q400NthDigit q400NthDigit = new Q400NthDigit();
        System.out.println(q400NthDigit.findNthDigit(1000000000));
//        System.out.println(q400NthDigit.countOfIntegers(11));
//        System.out.println(211111111 <= 90000000);
    }


    public int findNthDigit(int n) {
        if (n <= 0) return -1;
        int digits = 1;
        while (true) {
//            System.out.println("n: "+n);
//            System.out.println("digit: "+digits);
            long numbers = countOfIntegers(digits);
//            System.out.println("numbers: "+numbers);
            if (n <= numbers * digits) {
                break;
            }
            n -= numbers * digits;
            digits++;
        }
        return findNthDigit(n, digits);
    }


    int findNthDigit(int index, int digits) {
//         返回 digits 位数中的第 index 个数
//        System.out.println("digits: "+digits);
//        System.out.println("index: "+index);
        int number = beginNumber(digits) + (index - 1) / digits;
//        如果digits是1，第一个数的最后一位从1开始，其余digits位的第一个数都是从0开始
//        if (digits == 1) number--;
//        System.out.println(number);
        int digitsFromRight = digits - (index - 1) % digits;
        for (int i = 1; i < digitsFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }


    long countOfIntegers(int digits) {
//        返回digits位的数字的个数
        return 9 * (int) Math.pow(10, digits - 1);
    }


    int beginNumber(int digits) {
//         返回 digits 位数的第一个数
        return (int) Math.pow(10, digits - 1);
    }
}
