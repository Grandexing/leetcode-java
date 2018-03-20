package lintcode;

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
}
