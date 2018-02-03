package sword2offer;

public class Q51 {
    public static void main(String[] args) {
        Q51 q51 = new Q51();
//        int[] array = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int[] array = {7, 5, 4, 6, 2};
        System.out.println(q51.InversePairs(array));
    }


    public int InversePairs(int [] array) {
//        实质是一个归并排序，内部递归调用时，每次调换 array 和 copy 的位置，最后的返回结果，copy 是有序的，省去了调用内部的复制动作
//        最后复杂度其实是一样的？？？
        if (array == null || array.length <= 1) return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int result = inversePairs(array, copy, 0, array.length - 1);
        return result;
    }


    int inversePairs(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = inversePairs(copy, array, start, mid);
        int right = inversePairs(copy, array, mid + 1, end);
        int count = 0;
        int i = mid;
        int j = end;
        int index = end;
        while (i >= start && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[index] = array[i];
                i--;
            } else {
                copy[index] = array[j];
                j--;
            }
            index--;
        }
        while (i >= start) {
            copy[index] = array[i];
            index--;
            i--;
        }
        while (j > mid) {
            copy[index] = array[j];
            index--;
            j--;
        }
        return left + right + count;
    }
}
