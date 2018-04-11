package aljs4j.sort;

import java.util.Random;
//快排

public class Test{
    public static void main(String args[])
    {
        // int[] array = {2,8,17,4,3,8,11,3,0,6,17,4};
        // int[] array = {10,10,10,10,10};
        int[] array = millionTest();
        //升序数组
        // fs.fastSort(array,0,array.length-1);
        // for(int k=0; k<array.length;k++)
        // {
        //     System.out.print(" "+array[k]);
        // }
        long timeOne = System.currentTimeMillis();
//        fs.fastSort(array,0,array.length-1);
//        QuickSort.sort(array);
        long timeTwo = System.currentTimeMillis();
        System.out.println("sort time is: "+(timeTwo-timeOne));

    }


    private static int[] millionTest(){
        int num = 1000000;
        // Random ran = new Random();
        int[] oldArray = new int[num];
        for(int i=0;i<num;i++){
            // oldArray[i] = ran.nextInt(num);
            oldArray[i] = 10;

        }
        return oldArray;
    }
}

