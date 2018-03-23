package bishi.meituan;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.hasNextLine() ? scanner.nextLine() : "";
        char[] cs = line.toCharArray();
        String result = findMinNum(cs);
        System.out.println(result);
    }


    public static String findMinNum(char[] cs) {
        int[] items = new int[10];
        for (char c : cs) {
            if (c >= '0' && c <= '9') {
                items[c - '0']++;
            }
        }
        items[0]++;
        int min = 0;
        int minCount = items[0];
        for(int i = 1; i < 10; i++) {
            if(items[i] == 0) {
                return "" + i;
            } else if(items[i] < minCount) {
                System.out.println(min);
                minCount = items[i];
                min = i;
            }
        }
        String result = "";
        for(int i = 0; i < minCount; i++) {
            result = min + result;
        }
        if(min == 0) {
            result = 1 + result;
        } else {
            result = min + result;
        }
        return result;
    }


}
