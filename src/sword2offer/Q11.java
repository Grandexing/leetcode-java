package sword2offer;

public class Q11 {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1 || array[0] < array[array.length - 1]) return array[0];
        int start = 0;
        int end = array.length - 1;
        int middle = 0;
        int result = 0;
        while (end - start > 1) {
            middle = (start + end) / 2;
            if (array[start] == array[end] && array[start] == array[end]) {
                //此时无法判断最小值在哪个部分，只能顺序查找
                return minInOrder(array, start, end);
            }
            if (array[middle] >= array[start]) {
                start = middle;
            } else if (array[middle] <= array[end]) {
                end = middle;
            }
        }
        result = array[end];
        return result;
    }
    public int minInOrder(int [] array, int start, int end) {
        int result = array[start];
        for (int i = start; i <= end; i++) {
            if (array[i] < result) result = array[i];
        }
        return result;
    }
}
