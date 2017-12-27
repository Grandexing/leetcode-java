package leetcode;

/**
 * Created by grande on 2017/12/21.
 */
public class Q11ContainerWithMostWater {
    public static void main(String[] args) {

    }


    public static int maxArea(int[] height) {
        if (height==null || height.length==0) { return 0; }
        int max = 0;
        int N = height.length;
        int i = 0;
        int j = N - 1;
        while(i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]) {
                int k = i + 1;
                for (; k < j && height[k] <= height[i]; k++) {}
                i = k;
            } else {
                int k = j - 1;
                for (; k > i && height[k] <= height[j]; k--) {}
                j = k;
            }
        }
        return max;
    }

}
