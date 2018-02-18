package lintcode;

public class Q8RotateString {
//    http://www.lintcode.com/en/problem/rotate-string/


    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length <= 1 || offset <= 0) {
            return;
        }
        offset = offset % str.length;
        rotate(str, 0, str.length - 1);
        rotate(str, 0, offset - 1);
        rotate(str, offset, str.length - 1);
    }


    private void rotate(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
