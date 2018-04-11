package bishi.jingdong;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(find(s));
    }


    private static long find(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        int[][] dp = new int[len][len];
        for(int j=0;j<len;j++){
            dp[j][j]=1;
            for(int i=j-1;i>=0;i--){
                dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                if(str[i]==str[j])
                    dp[i][j]+=1+dp[i+1][j-1];
            }
        }
        return dp[0][len-1];
    }

}
