import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
//        int count = 0;
//        for (int y = n; y >= 1; y--) {
//            count += n / y * (y - k) + Math.max(0, n - n / y * y - (k - 1));
//        }
        if (k == 0) {
            System.out.println(n * n);
        } else {
            int count = 0;
            for (int i = k; i <= n; i++) {
                count += n - i;
            }
            for (int i = k + 1; i < n; i++) {
                count += (n / i - 1) * (i - k) + Math.max(0, n - i * (n / i) - k + 1);
            }
            System.out.println(count);
        }

//        for (int y = n; y >= 1; y--) {
//            for (int x = n; x >= 1; x--) {
//                if (x % y >= k) {
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
    }


}
