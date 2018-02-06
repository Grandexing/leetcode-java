package sword2offer;

/**
 * Created by grande on 2018/2/6.
 */
public class Q58Part1 {
// 面试题58（一）：翻转单词顺序
// 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
// 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
// 则输出"student. a am I"。

    public static void main(String[] args) {
        Q58Part1 q58Part1 = new Q58Part1();
        String s = "I am a student.";
        System.out.println(q58Part1.ReverseSentence(s));
    }

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) return str;
        char[] cs = str.toCharArray();
        reverse(cs, 0, cs.length - 1);
        int start = 0;
        int end = 0;
        while (start < cs.length) {
            while (end < cs.length && cs[end] != ' ') {
                end++;
            }
            reverse(cs, start, end - 1);
            end = end + 1;
            start = end;
        }
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
