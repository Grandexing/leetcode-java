package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "tmmzuxt";
//        String s = "dvdf";
//        String s = "abcabcbb";
        System.out.println(s);
        System.out.println(lengthOfLongestSubstring2(s));
    }


    public static int lengthOfLongestSubstring2(String s) {
        if(s==null || s.length() == 0) return 0;
        int[] posArr = new int[256];
        for (int i = 0; i < posArr.length; i++) {
            posArr[i] = -1;
        }
        char[] cs = s.toCharArray();
        int max = 0;
        char cur;
        for (int end = 0, start = 0; end < cs.length; end++) {
            cur = s.charAt(end);
            if (posArr[cur] < end){
                start = Math.max(start, posArr[cur] + 1);
            }
            posArr[cur] = end;
            max = Math.max(max, end - start + 1);
        }
        return max;
    }


    public static int lengthOfLongestSubstring1(String s) {
        if(s==null || s.length() == 0) return 0;
        char[] cs = s.toCharArray();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int end = 0, start = 0; end < cs.length; end++) {
            if (map.containsKey(cs[end])){
                start = Math.max(start, map.get(cs[end]) + 1);
            }
            map.put(cs[end], end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }


    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() == 0) return 0;
        int length = 1;
        int max = 1;
        int start = 0;
        char[] cs = s.toCharArray();
        HashMap<Character, Integer> strs = new HashMap<>();
        strs.put(cs[0], 0);
        for(int i = 1; i < cs.length; i++){
            if (!strs.containsKey(cs[i]) || strs.get(cs[i]) < start) {
                strs.put(cs[i], i);
                length = i - start + 1;
                if (max < length){
                    max = length;
                }
            }
            else {
                start = strs.get(cs[i]) + 1;
                strs.put(cs[i], i);
            }
            System.out.println("i: "+i);
            System.out.println("start: "+start);
            System.out.println("max: "+max);
            System.out.println("length: "+length);
        }
        return max;
    }
}
