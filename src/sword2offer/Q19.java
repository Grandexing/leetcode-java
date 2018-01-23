package sword2offer;

public class Q19 {
    public static void main(String[] args) {
        System.out.println(match("".toCharArray(), ".*".toCharArray()));
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
                return match(str, pattern, strIndex + 1, patternIndex + 2)
                        || match(str, pattern, strIndex + 1, patternIndex)
                        || match(str, pattern, strIndex, patternIndex + 2);
            } else {
                return match(str, pattern, strIndex, patternIndex + 2);
            }
        }
        if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex < str.length)) {
            return match(str, pattern, strIndex + 1, patternIndex + 1);
        }
        return false;
    }
}
