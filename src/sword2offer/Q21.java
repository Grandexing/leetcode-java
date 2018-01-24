package sword2offer;

public class Q21 {
    public void reOrderArray(int [] array) {
        if(array == null || array.length <= 1) return;
        int[] odds = new int[array.length];
        int[] evens = new int[array.length];
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 2) == 1) {
                odds[oddCount] = array[i];
                oddCount++;
            } else {
                evens[evenCount] = array[i];
                evenCount++;
            }
        }
        int i = 0;
        while (i < oddCount) {
            array[i] = odds[i];
            i++;
        }
        while (i < array.length) {
            array[i] = evens[i - oddCount];
            i++;
        }
    }
}
