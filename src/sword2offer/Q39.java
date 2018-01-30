package sword2offer;

import java.util.Random;

/**
 * Created by grande on 2018/1/30.
 */
public class Q39 {
    public static void main(String[] args) {
        Q39 q39 = new Q39();
        int[] array = {1,2,3,2,4,2,5,2,3};
        System.out.println(q39.MoreThanHalfNum_Solution(array));
    }


    public int MoreThanHalfNum_Solution_v2(int [] array) {
        if (array == null ) return 0;
        //右移一位，代表除以2
        int result = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                result = array[i];
                count = 1;
            } else if (array[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        if (!checkValidResult(array, result)) {
            result = 0;
        }
        return result;
    }


    Random random = new Random();


    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null ) return 0;
        //右移一位，代表除以2
        int middle = array.length >> 1;
        int lo = 0;
        int hi = array.length - 1;
        int index = partition(array, lo, hi);
        while (index != middle) {
            if (index > middle) {
//                此时中位数在左边
                hi = index - 1;
                index = partition(array, lo, hi);
            } else {
//                此时中位数在右边
                lo = index + 1;
                index = partition(array, lo, hi);
            }
        }
        int result = array[index];
        if (!checkValidResult(array, result)) {
//            如果result出现次数不到一半
            result = 0;
        }
        return result;
    }


    boolean checkValidResult(int[] array, int result) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) count++;
        }
        return count * 2 > array.length;
    }


    int partition(int[] array, int lo, int hi) {
        if (lo == hi) return lo;
        int j = random.nextInt(hi - lo + 1) + lo;
        swap(array, j, hi);
        int small = lo - 1;
        for (int i = lo; i < hi; i++) {
            if (array[i] < array[hi]) {
                small++;
                if (small != i) {
                    swap(array, small, i);
                }
            }
        }
        small++;
        swap(array, small, hi);
        return small;
    }


    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
