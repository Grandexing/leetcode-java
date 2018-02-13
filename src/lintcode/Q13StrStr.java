package lintcode;

public class Q13StrStr {
    public static void main(String[] args) {
        Q13StrStr q13StrStr = new Q13StrStr();
        System.out.println(q13StrStr.strStr("", ""));
    }

/*
http://www.lintcode.com/en/problem/strstr/#
 */

    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }
        if (target.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}
