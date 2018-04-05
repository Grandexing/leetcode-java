package aljs4j.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        int i;
        int a[] = {80, 40, 30, 60, 90, 70, 10, 50, 20};
        MaxHeap tree=new MaxHeap();

        System.out.printf("== 依次添加: ");
        for(i=0; i<a.length; i++) {
            System.out.printf("%d ", a[i]);
            tree.offer(a[i]);
        }

        System.out.printf("\n== 最 大 堆: %s", tree);
        while (!tree.isEmpty()) {
            System.out.println(tree.pop());
        }
    }


    private int[] queue;
    private int size = 0;

//    private Comparator<Integer> comparator;

    private static final int DEFAULT_INITIAL_CAPACITY = 11;


    public MaxHeap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }


    public MaxHeap(int initialCapacity) {
        queue = new int[initialCapacity];
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public boolean add(int e) {
        return offer(e);
    }


    public boolean offer(int e) {
        int i = size;
        if (i >= queue.length) {
//            扩容
            grow(i + 1);
        }
        size = i + 1;
        if (i == 0) {
            queue[0] = e;
        } else {
            queue[i] = e;
            swim(i);
        }
        return true;
    }


    public void grow(int minCapacity) {
        int oldCapacity = queue.length;
        //如果比较小，则扩容为原来的2倍，否则只扩容为原来的1.5倍
        int newCapacity = oldCapacity + (oldCapacity < 64 ? (oldCapacity + 2) : (oldCapacity >> 1) );
        queue = Arrays.copyOf(queue, newCapacity);
    }


    private void swim(int start) {
//        当前节点的位置
        int cur = start;
//        当前节点的值
        int curVal = queue[cur];
//        父节点的位置
        int parent = (cur - 1) / 2;
        while (cur > 0) {
            if (queue[parent] > queue[cur]) {
                break;
            } else {
                queue[cur] = parent;
                cur = parent;
                parent = (cur - 1) / 2;
            }
        }
        queue[cur] = curVal;
    }


    private void swap(int i, int j) {
        int tmp = queue[i];
        queue[i] = queue[j];
        queue[j] = tmp;
    }


    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int res = queue[0];
        queue[0] = queue[size - 1];
        size--;
        sink(0, size - 1);
        return res;
    }


    private void sink(int start, int end) {
        int cur = start;
        while (cur <= end) {
            int left = 2 * cur + 1;
            int right = 2 * cur + 2;
            int child = -1;
            if (left <= end && right <= end) {
                child = queue[left] >= queue[right] ? left : right;
            } else if (left <= end) {
                child = left;
            } else {
//                左右都在数组外，说明已到叶子节点
                return;
            }
            if (queue[cur] >= queue[child]) {
                return;
            }
            swap(cur, child);
            cur = child;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<queue.length; i++)
            sb.append(queue[i] +" ");

        return sb.toString();
    }


}
