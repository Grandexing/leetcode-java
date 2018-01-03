package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        int length = 1;
        int max = 1;
        char[] cs = s.toCharArray();
        Set<Character> strs = new HashSet<>();
        strs.add(cs[0]);
        for(int i = 1; i < cs.length; i++){
            if (cs[i - 1] != cs[i] && !strs.contains(cs[i])) {
                length++;
                strs.add(cs[i]);
            }
            else {
                length = 1;
                strs.clear();
                strs.add(cs[i]);
            }
            if (max < length){
                max = length;
            }
            System.out.println("max: "+max);
            System.out.println("length: "+length);
        }
        return max;
    }
}
