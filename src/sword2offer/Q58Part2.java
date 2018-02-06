package sword2offer;

/**
 * Created by grande on 2018/2/6.
 */
public class Q58Part2 {
// 面试题58（二）：左旋转字符串
// 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
// 请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数
// 字2，该函数将返回左旋转2位得到的结果"cdefgab"。

    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n <= 0 ||n % str.length() == 0) return str;
        n = n % str.length();
        int start = 0;
        int middle = n - 1;
        int end = str.length() - 1;
        char[] cs = str.toCharArray();
        reverse(cs, start, middle);
        reverse(cs, middle + 1, end);
        reverse(cs, start, end);
        return new String(cs);
    }


    void reverse(char[] cs, int start, int end) {
        if (start > end) return;
        while (start < end) {
            swap(cs, start, end);
            start++;
            end--;
        }
    }


    void swap(char[] cs, int start, int end) {
        char tmp = cs[start];
        cs[start] = cs[end];
        cs[end] = tmp;
    }
}
