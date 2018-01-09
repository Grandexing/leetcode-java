package leetcode;

public class Q8StringtoInteger {
    public static void main(String[] args) {
        String s = " -1010023630o4";
        System.out.println(myAtoi1(s));
    }


    public static int myAtoi1(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] cs = str.toCharArray();
//         for white space in the front
        int i = 0;
        long sgn = 1L;
        long value = 0L;
        while (cs[i] == ' ') i++;
        if (cs[i] == '+') {
            sgn = 1L;
            i++;
        } else if (cs[i] == '-') {
            sgn = -1L;
            i++;
        }
        int j = 0;
        while (i < cs.length) {
            if (cs[i] > 58 || cs[i] < 47) break;
            if (j > 11){
                if (sgn>0) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            value = value * 10L + (long)(cs[i] - 48);
            i++;
            j++;
//            System.out.println(value);
        }
//        System.out.println(value);
        value = value * sgn;
        System.out.println(value);
        if (value > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (value < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) value;
    }


    public static int myAtoi(String str) {
        long ans = 0;
        char[] chars = str.trim().toCharArray();
        if (chars.length==0) return 0;
        Long signal = 1L;
        int index = 0;
        if (chars[0] == '-'){
            index = 1;
            signal = -1L;
        }else if (chars[0] == '+'){
            index = 1;
            signal = 1L;
        }else if (chars[0]>58||chars[0]<47){
            return 0;
        }
        while (index<chars.length){
            if (index>11){
                if (signal>0) return Integer.MAX_VALUE;
                if (signal<0) return Integer.MIN_VALUE;
            }
            if (chars[index]>58||chars[index]<47) break;
            if ((int)chars[index] < 58 && (int)chars[index] > 47){
                ans = ans*10+((long) chars[index]-48);
            }
            index++;
        }
        System.out.println("ans="+ans);
        long res = signal * ans;
        if (res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }
}
