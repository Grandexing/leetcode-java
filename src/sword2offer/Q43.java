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
//            首位数大于1，首位数出现1的次数为10^length-1，如21345的首位是2，在1346到21345之间首位出现1的次数是10000
            numFirstDigit = (int)Math.pow(10, length - 1);
        } else if (first == 1){
//            首位数等于1，首位数出现1的次数为减掉首位数后加1，如11345的首位是1，在1346到11345之间首位出现1的次数是1346
            numFirstDigit = Integer.parseInt(new String(Arrays.copyOfRange(cs, start + 1, cs.length))) + 1;
        }
//        其他位数出现1的个数：以21345为例，分为 1346-11345 和 11346-21345 两段，每段实质上还是10000个数，后四位的变化和 0-9999相同
//        那么每个位置1出现的次数这么算：固定其中一个为1，则其他三位有10^3种可能（0-9），则 1346-21345 之间共有 4 * 2 * 1000 = 8000个1
        int numOfOtherDigit = first * (length - 1) * (int) (Math.pow(10, length - 2));
//        1-1345 中 1 的个数通过递归来求
        int numRecursive = numberOf1(cs, start + 1, length - 1);
        return numFirstDigit + numOfOtherDigit + numRecursive;
    }
}
