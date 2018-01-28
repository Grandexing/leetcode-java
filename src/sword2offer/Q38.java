package sword2offer;

import java.util.*;

public class Q38 {
    public static void main(String[] args) {
        Q38 q38 = new Q38();
//        ArrayList<String> result = q38.Permutation("abcd");
//        for (String s : result
//             ) {
//            System.out.println(s);
//        }
        ArrayList<StringBuffer> combineResult = q38.combine("abcd");
        for (StringBuffer s : combineResult
                ) {
            System.out.println(s);
        }
//        System.out.println(new String(Arrays.copyOfRange("abcd".toCharArray(), 0, 1)));
    }


    public ArrayList<StringBuffer> combine(String str) {
        ArrayList<StringBuffer> result = new ArrayList<>();
        if (str == null || str.length() == 0) return result;
        char[] cs = str.toCharArray();
        for (int i = 1; i <= cs.length; i++) {
            result.addAll(combine(cs, cs.length, i));
        }
        return result;
    }


    ArrayList<StringBuffer> combine(char[] cs, int n, int k) {
        if (k == 0 || k == n) {
            ArrayList<StringBuffer> result = new ArrayList<>();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < k; i++) {
                sb.append(cs[i]);
            }
            result.add(sb);
            return result;
        }
        ArrayList<StringBuffer> result = combine(cs, n - 1, k - 1);
        result.forEach(e -> e.append(cs[n - 1]));
        result.addAll(combine(cs, n - 1, k));
        return result;
    }


//    ArrayList<StringBuffer> combine(char[] cs, int n, int m, StringBuffer sb, ArrayList<StringBuffer> result) {
//        if (m == 0 || m == n) {
//            for (int i = 0; i < cs.length; i++) {
//                sb.append(cs[i]);
//            }
//            result.add(sb);
//            return result;
//        }
//        result = combine(cs, n - 1, m - 1, sb, result);
//        if (begin + m + 1 <= cs.length) {
//            sb.deleteCharAt(sb.length()-1);
//            combine(cs, begin + 1, m, result, sb);
//        }
//        return result;
//    }


    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) return result;
        permutation(str.toCharArray(), 0, result);
        Collections.sort(result);
        return result;
    }

    void permutation(char[] cs, int begin, ArrayList<String> result) {
        if (begin == cs.length && !result.contains(new String(cs))) {
            result.add(new String(cs));
            return;
        }
        for (int i = begin; i < cs.length; i++) {
            //交换第一个字符和后面的字符
            swap(cs, i, begin);
            //求当前第一个字符为cs[i]时，字符串的全排列
            permutation(cs, begin + 1, result);
            //交换回被交换的两个字符
            swap(cs, i, begin);
        }
    }


    void swap(char[] cs, int i, int j) {
        char temp = cs[j];
        cs[j] = cs[i];
        cs[i] = temp;
    }
}
