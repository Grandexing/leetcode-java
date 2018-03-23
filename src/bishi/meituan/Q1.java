package bishi.meituan;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.hasNextLine() ? scanner.nextLine() : "";
        String s2 = scanner.hasNextLine() ? scanner.nextLine() : "";
        int distance = getAllDistance(s1, s2);
        System.out.println(distance);
    }


    public static int getAllDistance(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < s2.length()) {
            return 0;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int total = 0;
        for (int i = 0; i < len1 - len2 + 1; i++) {
            int distance = getDistance(s1, i, i + len2 - 1, s2);
            total += distance;
        }
        return total;
    }


    private static int getDistance(String s1, int start, int end, String s2) {
        int distance = 0;
        int start2 = 0;
        while (start <= end && start2 < s2.length()) {
            if (s1.charAt(start) != s2.charAt(start2)) {
                distance++;
            }
            start++;
            start2++;
        }
        return distance;
    }
}
