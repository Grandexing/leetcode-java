/**
 * Created by grande on 2017/5/18.
 */
public class StringToInteger {
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

    public static void main(String[] args) {
        String i = "9223372036854775809";
        System.out.println(myAtoi(i));
        System.out.println(Long.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }
}
