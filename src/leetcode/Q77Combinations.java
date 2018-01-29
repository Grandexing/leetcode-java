package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || k == n) {
            List<Integer> row = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                row.add(i);
            }
            return new ArrayList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(combine(n - 1, k));
        return result;
    }


    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n + 1 - k; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}
