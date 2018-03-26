package bishi.toutiao;

import java.util.Scanner;
import java.util.Arrays;

public class Main5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int h = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int result = getHeight(nums, n, k, h);
        System.out.println(result);
    }


    public static int getHeight(int[] nums, int n, int k, int h) {
        Arrays.sort(nums);
        int[] f = new int[k + 1];
        f[0] = 0;
        int nh = 0;
        for (int i = 1; i <= k; i++){
            while ((nh < n - 1) && (f[i - 1] + h >= nums[nh + 1])){
                nh++;
            }
            if (f[i - 1] >= nums[nh] || f[i - 1] + h < nums[nh]){
                f[i] = f[i - 1];
            } else{
                f[i] = f[i - 1] + (nums[nh] - f[i - 1]) * 2;
            }
        }
        return f[k];
    }
}