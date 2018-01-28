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
}
