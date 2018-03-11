package lintcode;

import java.util.*;

public class Q545TopkLargestNumbersII {
    /*
* @param k: An integer

bugfree:
1. it.next() 需要强制转换，(Integer)it.next()
2. reverse order 的写法：Collections.reverseOrder()
*/public Q545TopkLargestNumbersII(int k) {
        // do intialization if necessary
        this.minHeap = new PriorityQueue<>();
        this.maxSize = k;
    }

    private PriorityQueue<Integer> minHeap;
    private int maxSize;

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if (minHeap.size() < maxSize) {
            minHeap.offer(num);
            return;
        }
        if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(num);
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        Iterator it = minHeap.iterator();
        List<Integer> result = new ArrayList<>();
        while (it.hasNext()) {
            result.add((Integer)it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}
