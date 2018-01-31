package sword2offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q41 {
    public static void main(String[] args) {
        Q41 q41 = new Q41();
        int[] a = {5,2,3,4,1,6,7,0,8};
        for (int i : a) {
            q41.Insert(i);
            System.out.println(q41.GetMedian());
        }
    }


    //最大堆：最大元素小于最小堆的最小元素
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    //最小堆：最小元素小于最大堆的最大元素
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public void Insert(Integer num) {
        if (((minHeap.size() + maxHeap.size()) & 1) == 0) {
            //当前总数为偶数，下一个插入最小堆
            if (maxHeap.size() > 0 && num < maxHeap.peek()) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        } else {
            //当前总数为奇数，下一个插入最大堆
            if (minHeap.size() > 0 && num > minHeap.peek()) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }
        System.out.println("minHeap: "+minHeap);
        System.out.println("maxHeap: " + maxHeap);
    }

    public Double GetMedian() {
        //size 为 0，需要异常处理
        int size = minHeap.size() + maxHeap.size();
        if (size == 0) return 0.0;
        double median = 0;
        if ((size & 1) == 0) {
            median = (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            median = minHeap.peek();
        }
        return median;
    }

}
