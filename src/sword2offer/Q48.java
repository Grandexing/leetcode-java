package sword2offer;

public class Q48 {
    //    leetcode Q3
    public static void main(String[] args) {
        Q48 q48 = new Q48();
        q48.test();
    }


    public int longestSubStringWithoutDuplication_1(String s) {
//        之前在 LeetCode 上学到的方法
        if (s == null || s.isEmpty()) return 0;
        int[] inStr = new int[26];
        for (int i = 0; i < inStr.length; i++) {
            inStr[i] = -1;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        int index = 0;
        while (end < s.length()) {
            index = s.charAt(end) - 'a';
            if (inStr[index] >= 0) {
//                注意这里
                start = Math.max(inStr[index] + 1, start);
            }
            inStr[index] = end;
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }

    public int longestSubStringWithoutDuplication_2(String s) {
//        书上的方法
        if (s == null || s.isEmpty()) return 0;
        int curLength = 0;
        int maxLength = 0;
        int[] position = new int[26];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int preIndex = position[s.charAt(i) - 'a'];
            if (preIndex < 0 || i - preIndex > curLength) {
//                当前字符未出现，或者出现过但在当前最大长度之外
                curLength++;
            } else {
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = i - preIndex;
            }
            position[s.charAt(i) - 'a'] = i;
        }
        if (curLength > maxLength) {
            maxLength = curLength;
        }
        return maxLength;
    }

    void testSolution1(String input, int expected) {
        int output = longestSubStringWithoutDuplication_1(input);
        if (output == expected)
            System.out.println("Solution 1 passed, with input: " + input);
        else
            System.out.println("Solution 1 FAILED, with input: " + input);
    }

    void testSolution2(String input, int expected) {
        int output = longestSubStringWithoutDuplication_2(input);
        if (output == expected)
            System.out.println("Solution 2 passed, with input: " + input);
        else
            System.out.println("Solution 2 FAILED, with input: " + input);
    }

    void test(String input, int expected) {
        testSolution1(input, expected);
        testSolution2(input, expected);
    }

    void test1() {
        String input = "abcacfrar";
        int expected = 4;
        test(input, expected);
    }

    void test2() {
        String input = "acfrarabc";
        int expected = 4;
        test(input, expected);
    }

    void test3() {
        String input = "arabcacfr";
        int expected = 4;
        test(input, expected);
    }

    void test4() {
        String input = "aaaa";
        int expected = 1;
        test(input, expected);
    }

    void test5() {
        String input = "abcdefg";
        int expected = 7;
        test(input, expected);
    }

    void test6() {
        String input = "aaabbbccc";
        int expected = 2;
        test(input, expected);
    }

    void test7() {
        String input = "abcdcba";
        int expected = 4;
        test(input, expected);
    }

    void test8() {
        String input = "abcdaef";
        int expected = 6;
        test(input, expected);
    }

    void test9() {
        String input = "a";
        int expected = 1;
        test(input, expected);
    }

    void test10() {
        String input = "";
        int expected = 0;
        test(input, expected);
    }

    void test() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
    }
}
