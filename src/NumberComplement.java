/**
 * Created by grande-xing on 2017/6/7.
 */
public class NumberComplement {
    public static void main(String[] args) {
        int num = 12;
        System.out.println("\n"+findComplement(num));
//        System.out.println((int) '0' - 48);
    }
    public static int findComplement(int num) {
        String bs = Integer.toBinaryString(num);
        int length = bs.length();
        System.out.println(bs);
        int result = 0;
        for (int i = 0; i < length; i++) {
            int b = 49 - bs.charAt(i);
//            System.out.print(b);
            result+=Math.pow(2, length - 1 - i) * b;
        }
        return result;
    }
}
