package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q17LetterCombinationsofaPhoneNumber {
//

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        HashMap<Character, char[]> map = initial();
        dfs(digits, 0, ans, new StringBuilder(), map);
        return ans;
    }


    private void dfs(String digits, int index, List<String> ans, StringBuilder cur, HashMap<Character, char[]> map) {
        if (index == digits.length()) {
            ans.add(cur.toString());
            return;
        }
        for (char c : map.get(digits.charAt(index))) {
            cur.append(c);
            dfs(digits, index + 1, ans, cur, map);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    private HashMap<Character, char[]> initial() {
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('1', new char[0]);
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        return map;
    }
}
