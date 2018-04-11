package aljs4j.sort;

import java.util.Arrays;

public class RadixSort {

    static void sort(int[] nums) {
//        int max = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            max = Math.max(max, nums[i]);
//        }
        int maxBit = maxBit(nums);
        int radix = 10;
        int exp = 1;
        int n = nums.length;
        int[] aux = new int[n];
        int[] count = new int[radix];
        int k;
        for(int j = 1; j <= maxBit; j++) {
//            进行d次排序
            Arrays.fill(count, 0);//每次分配前清空计数器
            for (int i = 0; i < n; i++) {
                k = (nums[i] / exp) % 10;//统计每个桶中的记录数
                count[k]++;
            }
            for (int i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];//将tmp中的位置依次分配给每个桶
            }
            for (int i = n - 1; i >= 0; i--) {
                //将所有桶中记录依次收集到tmp中
//                从后往前添加，这样是稳定的
                k = (nums[i] / exp) % 10;
                aux[count[k] - 1] = nums[i];
                count[k]--;
            }
            for (int i = 0; i < n; i++) {
                //将临时数组的内容复制到data中
                nums[i] = aux[i];
            }
            exp *= 10;
        }
    }


    static int maxBit(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int radix = 10;
        int exp = 1;
        while (max >= radix) {
            max /= 10;
            exp++;
        }
        return exp;
    }
}
