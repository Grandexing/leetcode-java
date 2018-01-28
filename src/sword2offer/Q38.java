package sword2offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Q38 {
    public static void main(String[] args) {
        Q38 q38 = new Q38();
        ArrayList<String> result = q38.Permutation("abcd");
        for (String s : result
             ) {
            System.out.println(s);
        }
    }


    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) return new ArrayList<>();
        permutation(str.toCharArray(), 0, result);
//        Collections.sort(result);
        return result;
    }

    void permutation(char[] cs, int begin, ArrayList<String> result) {
        if (begin == cs.length && !result.contains(new String(cs))) {
            result.add(new String(cs));
            return;
        }
        for (int i = begin; i < cs.length; i++) {
            //交换第一个字符和后面的字符
            char temp = cs[begin];
            cs[begin] = cs[i];
            cs[i] = temp;
            //求当前第一个字符为cs[i]时，字符串的全排列
            permutation(cs, begin + 1, result);
            //交换回被交换的两个字符
            temp = cs[i];
            cs[i] = cs[begin];
            cs[begin] = temp;
        }
    }
}
