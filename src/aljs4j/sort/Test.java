package aljs4j.sort;

import java.util.Random;
//快排
class FastSort{

    public void randomPivotChoose(int array[], int start, int end)
    {
        Random rand = new Random();
        int tmp = array[start];
        int randIndex = start+rand.nextInt(end-start);
        array[start] = array[randIndex];
        array[randIndex] = tmp;
    }

    public void mediumPivotChoose(int array[], int start, int end)
    {
        int tmp;
        int medium = start + (end-start)/2;
        if (array[start] > array[end])
        {
            tmp = array[end];
            array[end] = array[start];
            array[start] = tmp;
        }

        if (array[start] > array[medium])
        {
            tmp = array[medium];
            array[medium] = array[start];
            array[start] = tmp;
        }

        if (array[medium] > array[end])
        {
            tmp = array[medium];
            array[medium] = array[end];
            array[end] = tmp;
        }
        tmp = array[start];
        array[start] = array[medium];
        array[medium] = tmp;
    }


    public int partition(int[] array, int start, int end)
    {
        //随机选轴
        // mediumPivotChoose(array, start, end);
        int pivot = array[start];
        int i=start;
        int j=end;

        while(i<j)
        {
            while(i<j && array[j] >= pivot)
            {
                j--;
            }

            if(i<j)
            {
                array[i++] = array[j];
            }

            while(i<j && array[i] <= pivot)
            {
                i++;
            }

            if(i<j)
            {
                array[j--] = array[i];
            }
        }
        array[i] = pivot;
        return i;
    }


    public void fastSort(int[] array, int start, int end)
    {
        if(start >= end)
        {
            return;
        }

        int i = partition(array, start, end);
        fastSort(array, start, i-1);
        fastSort(array, i+1, end);
    }

}

//快排
class OptimizedFastSort{

    public int partition(int[] array, int start, int end)
    {
        int pivot = array[start];
        int i=start;
        int j=end;

        while(i<j)
        {
            while(i<j && array[j] >= pivot)
            {
                j--;
            }

            if(i<j)
            {
                array[i++] = array[j];
            }

            while(i<j && array[i] <= pivot)
            {
                i++;
            }

            if(i<j)
            {
                array[j--] = array[i];
            }
        }
        array[i] = pivot;
        return i;
    }


    public void fastSort(int[] array, int start, int end)
    {
        if(start >= end)
        {
            return;
        }

        int i = partition(array, start, end);
        fastSort(array, start, i-1);
        fastSort(array, i+1, end);
    }

}

public class Test{
    public static void main(String args[])
    {
        FastSort fs = new FastSort();
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

