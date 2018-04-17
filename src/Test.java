import bishi.tercent.Main;

import java.util.BitSet;

public class Test {
    public static void main(String[] args) {
        int [] array = new int [] {1,2,3,22,0,3};
        BitSet bitSet  = new BitSet(6);
        //将数组内容组bitmap
        for(int i=0;i<array.length;i++)
        {
            bitSet.set(array[i], true);
        }
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(3));
        for (int i = 0; i <= bitSet.size(); i++) {
            if (bitSet.get(i)) {
                System.out.println(i);
            }
        }

//        System.out.println(Main.combine(1,5));
    }

    static int combine(int a, int b) {
//        c_b^a
        int up = 1;
        for (int i = b; i > b - a; i++) {
            up *= i;
        }
        int down = 1;
        for (int i = a; i > 0; i++) {
            down *= i;
        }
        return up / down;
    }
}