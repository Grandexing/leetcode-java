package lintcode;

public class Q145RegularExpressionMatching {
//    http://www.lintcode.com/en/problem/regular-expression-matching/

    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s, 0, p, 0);
    }


    private boolean isMatch(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (sIndex != s.length() && pIndex == p.length()) {
            return false;
        }
        if (pIndex != p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            if (match(s, sIndex, p, pIndex)) {
                return isMatch(s, sIndex, p, pIndex + 2) || isMatch(s, sIndex + 1, p, pIndex);
            } else {
                return isMatch(s, sIndex, p, pIndex + 2);
            }
        }
        if (match(s, sIndex, p, pIndex)) {
            return isMatch(s, sIndex + 1, p, pIndex + 1);
        }
        return false;
    }


    private boolean match(String s, int sIndex, String p, int pIndex) {
        if (sIndex >= s.length()) {
            // aa match a*
            return false;
        }
        return s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.';
    }


    public boolean isMatch1(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            // a*b*c*
            if (pp[i - 1] == '*' && i - 2 >= 0 && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= ss.length; i++) {
            for (int j = 1; j <= pp.length; j++) {
                if (pp[j - 1] != '*') {
                    if (ss[i - 1] == pp[j - 1] || pp[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (j - 2 >= 0) {
                        if (pp[j - 2] != '.' && pp[j - 2] != ss[i - 1]) {
                            // 0 match
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            // 0 match / 1 match / multi match
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i - 1][j - 2];
                        }
                    }
                }
            }
        }
        return dp[ss.length][pp.length];
    }
}
