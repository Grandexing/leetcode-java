package leetcode;

/**
 * Created by grande on 2018/1/7.
 */
public class Q28ImplementstrStr {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        System.out.println(strStr(s1, s2));
    }


    public static int strStr(String haystack, String needle) {
        // int index = -1;
        if (needle.length() == 0) {
            return 0;
            // if (haystack.length() == 0) return 0;
        }
        char[] needleStr = needle.toCharArray();
        char[] haystackStr = haystack.toCharArray();
        for (int i = 0; i < haystackStr.length - needleStr.length + 1; i++) {
            if (haystackStr[i] == needleStr[0]){
                int j = 1;
                while (j < needleStr.length) {
                    if (needleStr[j] != haystackStr[i + j]) break;
                    else j++;
                }
                if (j == needleStr.length) {
                    return i;
                }
            }
        }
        return -1;
    }
}
