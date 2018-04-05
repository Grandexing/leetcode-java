import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class ResultType {
        int countA;
        int countB;
        ResultType (int countA, int countB) {
            this.countA = countA;
            this.countB = countB;
        }
    }
    static int mod = 1000000007;
    public static void main(String[] args) {
//        System.out.println(combine(1, 5));
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int lenA = scanner.nextInt();
        int numA = scanner.nextInt();
        int lenB = scanner.nextInt();
        int numB = scanner.nextInt();
        List<ResultType> result = new ArrayList<>();
        dfs(k, 0, lenA, numA, 0, lenB, numB, result);
        HashSet<Long> set = new HashSet<>();
        for (ResultType rt : result) {
//            System.out.println(rt.countA + " " + rt.countB);
            long res = combine(rt.countA, numA) * combine(rt.countB, numB) % mod;
            set.add(res);
//            System.out.println(res);
        }
        for (long i : set) {
            System.out.println(i);
        }
    }


    static void dfs(int remain, int curA, int lenA, int numA, int curB, int lenB, int numB, List<ResultType> result) {
        if (remain < 0 || curA > numA || curB > numB) {
            return;
        }
        if (remain == 0) {
            result.add(new ResultType(curA, curB));
        }
        dfs(remain - lenA, curA + 1, lenA, numA, curB, lenB, numB, result);
        dfs(remain - lenB, curA, lenA, numA, curB + 1, lenB, numB, result);
    }


    static long combine(int a, int b) {
//        c_b^a
        long up = 1;
        for (int i = b; i > b - a; i--) {
            up *= i;
        }
        long down = 1;
        for (int i = a; i > 0; i--) {
            down *= i;
        }
        return up % mod / down % mod;
    }
}
/*
5
2 3 3 3
 */
