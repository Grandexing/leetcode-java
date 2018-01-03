package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "tmmzuxt";
//        String s = "dvdf";
//        String s = "abcabcbb";
        System.out.println(s);
        System.out.println(lengthOfLongestSubstring(s));
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
//                length++;
                strs.put(cs[i], i);
                length = i - start + 1;
                if (max < length){
                    max = length;
                }
            }
            else {
                start = strs.get(cs[i]) + 1;
//                strs.clear();
                strs.put(cs[i], i);
            }
//            if (max < length){
//                max = length;
//            }
            System.out.println("i: "+i);
            System.out.println("start: "+start);
            System.out.println("max: "+max);
            System.out.println("length: "+length);
        }
        return max;
    }
}
