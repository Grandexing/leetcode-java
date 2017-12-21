package leetcode;

/**
 * Created by grande on 2017/12/21.
 */
public class Q11ContainerWithMostWater {
    public static void main(String[] args) {
        
    }


    public static int maxArea(int[] height) {
        int maxContainer = 0;
        int N = height.length;
        for (int i = 1; i <= N; i++){
            for (int j = 0; j < N - i; j++) {
                int container = i * min(height[j], height[j + i]);
                if (container > maxContainer) maxContainer = container;
            }
        }
        return maxContainer;
    }


    static int min(int a, int b) {
        if(a < b) return a;
        else return b;
    }
}
