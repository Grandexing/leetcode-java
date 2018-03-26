package leetcode;

import java.util.HashMap;

public class Q290WordPattern {
//    https://leetcode.com/problems/word-pattern/description/

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || pattern.isEmpty() || str.isEmpty()) {
            return false;
        }
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> cs = new HashMap<>();
        HashMap<String, Character> sc = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (cs.containsKey(c)) {
                if (!word.equals(cs.get(c))) {
                    return false;
                }
            } else {
                if (sc.containsKey(word)) {
                    return false;
                } else {
                    cs.put(c, word);
                    sc.put(word, c);
                }
            }
        }
        return true;
    }
}
