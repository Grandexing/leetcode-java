package sword2offer;

public class Q19 {
    public static void main(String[] args) {
        System.out.println(match("".toCharArray(), ".*".toCharArray()));
    }

//动态规划（bottom up）
    public boolean match1(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) return false;
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (pattern[j] == str[i]) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (pattern[j] == '*') {
                    if (pattern[j - 1] != str[i] && pattern[j - 1] != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[str.length][pattern.length];
    }


    public static boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) return false;
        return match(str, pattern, 0, 0);
    }


    static boolean match(char[] str, char[] pattern, int strIndex, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) return true;
        if (strIndex != str.length && patternIndex == pattern.length) return false;
        if (patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex < str.length)) {
                return match(str, pattern, strIndex, patternIndex + 2)
//                        此情况包含在另两种情况中，注释掉也可以通过
//                        || match(str, pattern, strIndex + 1, patternIndex + 2)
                        || match(str, pattern, strIndex + 1, patternIndex);
            } else {
                return match(str, pattern, strIndex, patternIndex + 2);
            }
        }
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex < str.length)) {
            return match(str, pattern, strIndex + 1, patternIndex + 1);
        }
        return false;
    }
}
