package bishi.wangyihuyu;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int len = Integer.parseInt(scanner.nextLine());
            String[] strs = new String[len];
            for (int i = 0; i < len; i++) {
                strs[i] = scanner.nextLine();
//                System.out.println(strs[i].length());
            }
//            String[] strs = {"lls", "s", "", "sssll"};
            int result = findAllPalindrome(strs);
            System.out.println(result);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("input error");
        }
    }


    public static int findAllPalindrome(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i != j) {
                    if (isPalindrome(strs[i], strs[j])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    private static boolean isPalindrome(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        String s = s1 + s2;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
