package sword2offer;

import java.util.Arrays;

public class Q43 {
    public static void main(String[] args) {
        Q43 q43 = new Q43();
        System.out.println(q43.NumberOf1Between1AndN_Solution(21345));
    }


    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) return 0;
        char[] cs = String.valueOf(n).toCharArray();
        return numberOf1(cs, 0, cs.length);
    }


    int numberOf1(char[] cs, int start, int length) {
        if (start == cs.length) return 0;
        int first = cs[start] - '0';
        if (start == cs.length - 1) {
            if (first == 0) return 0;
            if (first > 0) return 1;
        }
        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = (int)Math.pow(10, length - 1);
        } else if (first == 1){
            numFirstDigit = Integer.parseInt(new String(Arrays.copyOfRange(cs, start + 1, cs.length))) + 1;
        }
        int numOfOtherDigit = first * (length - 1) * (int) (Math.pow(10, length - 2));
        int numRecursive = numberOf1(cs, start + 1, length - 1);
        System.out.println(numFirstDigit);
        System.out.println(numOfOtherDigit);
        System.out.println(numRecursive);
        return numFirstDigit + numOfOtherDigit + numRecursive;
    }
}
