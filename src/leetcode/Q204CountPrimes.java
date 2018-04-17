package leetcode;

public class Q204CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] noPrime = new boolean[n];
        int max = (int)Math.floor(Math.sqrt(n - 1));
        System.out.println(max);
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (!noPrime[i]) {
                int j = i * i;
                while (j < n) {
                    if (!noPrime[j]) {
                        noPrime[j] = true;
                        count--;
                    }
                    j += i + i;
                }
            }
        }
        return count;
    }
}
