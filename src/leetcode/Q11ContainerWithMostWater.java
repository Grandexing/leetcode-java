package leetcode;

/**
 * Created by grande on 2017/12/21.
 */
public class Q11ContainerWithMostWater {
    public static void main(String[] args) {

    }

//more simple loop inside
    public static int maxAreaOptimal2(int[] height) {
        if (height==null || height.length==0) { return 0; }
        int max = 0;
        int N = height.length;
        int i = 0;
        int j = N - 1;
        while(i < j) {
            int iMax = height[i], jMax = height[j];
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]) {
                while (i < j && height[i] < iMax) {
                    ++i;
                }
            } else {
                while (i < j && height[j] < jMax) {
                    ++j;
                }
            }
        }
        return max;
    }

    public static int maxAreaOptimal1(int[] height) {
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


    public static int maxAreaCommon(int[] height) {
        if (height==null || height.length==0) { return 0; }
        int max = 0;
        int N = height.length;
        int i = 0;
        int j = N - 1;
        while(i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

}
