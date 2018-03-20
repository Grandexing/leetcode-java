package lintcode;

import java.util.Arrays;

public class Q53ReverseWordsinaString {
//    http://www.lintcode.com/en/problem/reverse-words-in-a-string/

    public String reverseWords(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return s;
        }
        String[] array = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }


    public String reverseWords1(String s) {
        // write your code here
//        这种方法太复杂了...
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] cs = s.trim().toCharArray();
        int end = removeExtraSpace(cs);
        reverse(cs, 0, end - 1);
        int start = 0;
        for (int i = 1; i < end; i++) {
            if (cs[i] == ' ') {
                reverse(cs, start, i - 1);
                start = i + 1;
            } else if (i == end - 1){
                reverse(cs, start, i);
            }
        }
        return new String(Arrays.copyOf(cs, end));
    }


    private int removeExtraSpace(char[] cs) {
        int end = 0;
        int index = 0;
        while (index < cs.length) {
            if (cs[index] == ' ' && index > 0 && cs[index - 1] == ' ') {
                index++;
            } else {
                if (index != end) {
                    cs[end] = cs[index];
                }
                index++;
                end++;
            }
        }
        return end;
    }


    private void reverse(char[] cs, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        while(left < right) {
            swap(cs, left, right);
            left++;
            right--;
        }
    }


    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] =tmp;
    }
}
