import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            b[i] = sc.nextInt();
        }

        long[] dp = new long[m + 1];
        dp[0] = 1;

        for (int i = 0; i < n1; i++) {
            for (int k = a[i]; k <= m; k++) {
                dp[k] = (dp[k] + dp[k - a[i]]) % 1000000007;
            }
        }

        for (int i = 0; i < n2; i++) {
            for (int k = m; k >= b[i]; k--) {
                dp[k] = (dp[k] + dp[k - b[i]]) % 1000000007;
            }
        }
        System.out.println(dp[m]);
    }
}
/*
3 1 5
1 2 3
1
 */