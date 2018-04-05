package lintcode;

public class Q78LongestCommonPrefix {
//    http://www.lintcode.com/en/problem/longest-common-prefix/

    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int end = prefix.length();
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < strs[i].length() && j < end && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if (j < end) {
                end = j;
            }
        }
        return prefix.substring(0, end);
    }
}
