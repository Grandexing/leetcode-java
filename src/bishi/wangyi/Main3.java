package bishi.wangyi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] payArr = new int[n];
        HashMap<Integer, Integer> hardMap = new HashMap<>();
        int tmp = 0;
        for (int i = 0; i < n; i++){
            tmp = scanner.nextInt();
            payArr[i] = scanner.nextInt();
            hardMap.put(payArr[i], tmp);
        }
        int[] ai = new int[m];
        for (int i = 0; i < n; i++){
            ai[i] = scanner.nextInt();
        }
        Arrays.sort(payArr);
        for (int i = 0; i < ai.length; i++){
            for (int j = payArr.length - 1; j >=0; j--){
                if (ai[i] >= hardMap.get(payArr[j])){
                    System.out.println(payArr[j]);
                    break;
                }
            }
        }
    }
    private static void helper(int[] pay, Map<Integer, Integer> hard, int[] abi){
        Arrays.sort(pay);
        for (int i = 0; i < abi.length; i++){
            for (int j = pay.length - 1; j >=0; j--){
                if (abi[i] >= hard.get(pay[j])){
                    System.out.println(pay[j]);
                    break;
                }
            }
        }
    }
}
