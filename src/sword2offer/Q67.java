package sword2offer;

public class Q67 {
// 面试题67：把字符串转换成整数
// 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
// 能使用atoi或者其他类似的库函数。

    public int StrToInt(String str) {
        long number = 0;
        if (str != null && str.length() > 0) {
            int length = str.length();
            int index = 0;
            int sign = 1;
            //可能存在的符号位的处理
            if (str.charAt(index) == '+' || str.charAt(index) == '-') {
                if (length == 1) {
                    //只有正负号的情况
                    return 0;
                }
                if (str.charAt(index) == '-') {
                    sign = -1;
                }
                index++;
            }
            char num;
            while (index < length) {
                num = str.charAt(index);
                if (num >= '0' && num <= '9') {
                    number = number * 10 + sign * (num - '0');
                    if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
                        number = 0;
                        break;
                    }
                } else {
                    number = 0;
                    break;
                }
                index++;
            }
        }
        return (int) number;
    }
}
