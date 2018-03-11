package lintcode;

public class Q200LongestPalindromicSubstring {
    public String longestPalindromev1(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return "";
        }
        int longest = 1;
        int start = 0;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (longest == 1 && isPalindrome[i][i + 1] == true) {
                start = i;
                longest = 2;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (isPalindrome[i][j] && j - i + 1 > longest) {
                    start = i;
                    longest = j - i + 1;
                }
            }
        }
        return s.substring(start, start + longest);
    }


    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return "";
        }
        int start = 0;
        int len = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            len =  findLongestPalindrome(s, i, i);
            if (len > longest) {
                longest = len;
                start = i - len / 2;
            }
            len = findLongestPalindrome(s, i, i+1);
            if (len > longest) {
                longest = len;
                start = i - len / 2 + 1;
            }
        }
        return s.substring(start, start + longest);
    }


    private int findLongestPalindrome(String s, int left, int right) {
        // from middle to side
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        // (right - 1) - (left + 1) + 1
        int len = right - left - 1;
        return len;
    }
}
