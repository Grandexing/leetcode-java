import java.util.Arrays;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] noPrime = new boolean[n + 1];
//        2 is prime
//        noPrime[2] = false;
//        int max = (int)Math.floor(Math.sqrt(n - 1));
//        System.out.println(max);
        int count = n - 1;
//        找到所有质数
        for (int i = 2; i * i < n; i++) {
            if (!noPrime[i]) {
                int j = i * i;
                while (j < n) {
                    if (!noPrime[j]) {
                        noPrime[j] = true;
                        count--;
                    }
                    j += i;
                }
            }
        }
//        for (int i = 0; i <= n; i++) {
//            if (!noPrime[i]) {
//                System.out.print(i+" ");
//            }
//        }
//        System.out.println();
//        prime count
        for (int i = 2; i <= n; i++) {
            if (!noPrime[i]) {
                int j = i * i;
                while (j <= n) {
//                    System.out.print(j+" ");
                    count++;
                    j *= i;
                }
            }
        }
//        System.out.println();
        System.out.println(count);
    }
}
/*
37
 */