package sword2offer;

/**
 * Created by grande on 2018/2/1.
 */
public class Q49 {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        int[] uglys = new int[index];
        uglys[0] = 1;
        int min2 = 0;
        int min3 = 0;
        int min5 = 0;
        int nextUglyIndex = 1;
        while(nextUglyIndex < index) {
            int min = min(uglys[min2] * 2, uglys[min3] * 3, uglys[min5] * 5);
            uglys[nextUglyIndex] = min;
            while (uglys[min2] * 2 <= min) {
                min2++;
            }
            while (uglys[min3] * 3 <= min) {
                min3++;
            }
            while (uglys[min5] * 5 <= min) {
                min5++;
            }
            nextUglyIndex++;
        }
        return uglys[nextUglyIndex - 1];
    }


    int min(int n1, int n2, int n3) {
        int min = Math.min(n1, n2);
        return Math.min(min, n3);
    }
}
