package bishi.jingdong;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
//        System.out.println(n);
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(scanner.nextLine());
//            System.out.println(data[i]);
        }
        for (int item : data) {
            System.out.println(findXY(item));
        }
    }


    private static String findXY(int n) {
        if (n % 2 == 1) {
            return "No";
        }
//        if ((n & (n - 1)) == 0) {
//            return 1 + " " + n;
//        }
        int x = n;
        while (x % 2 == 0) {
            x /= 2;
        }
        int y = n / x;
        return x + " " + y;
    }
}
/*
2
10
5
 */