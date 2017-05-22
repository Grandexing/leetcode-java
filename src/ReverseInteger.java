/**
 * Created by grande on 2017/5/17.
 */
public class ReverseInteger {
    public static int reverse(int x) {
        String signal = "";
        String s1 = String.valueOf(x);
        if (x < 0){
            signal = "-";
            s1 = s1.substring(1);
        }
        String s2 = new StringBuilder(s1).reverse().toString();
        long y = Long.parseLong(signal + s2, 10);
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE){
            return 0;
        }
        return (int)y;
    }

    public static int reverseV2(int x){
        int rev = 0;
        while(x != 0){
            rev = rev * 10 + x%10;
            x = x/10;
        }
        return rev;
    }

    public static int getLen(int x){
        int len = 0;
        int temp = x;
        while (temp != 0){
            len++;
            temp = temp / 10;
        }
        return len;
    }

    public static void main(String[] args) {
        int x = -123435;
        System.out.println(reverseV2(x));
    }
}
