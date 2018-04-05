package aljs4j.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
    public static void main(String[] args) {
        int i;
        int a[] = {80, 40, 30, 60, 90, 70, 10, 50, 20};
        MinHeap<Integer> tree=new MinHeap<Integer>();

        System.out.printf("== 依次添加: ");
        for(i=0; i<a.length; i++) {
            System.out.printf("%d ", a[i]);
            tree.offer(a[i]);
            System.out.println("当前堆："+tree);
        }

        System.out.printf("\n== 最 小 堆: %s", tree);
        System.out.println();
        while (!tree.isEmpty()) {
            System.out.println("当前堆："+tree);
            System.out.println(tree.pop());
        }

//        i=15;
//        tree.offer(i);
//        System.out.printf("\n== 添加元素: %d", i);
//        System.out.printf("\n== 最 小 堆: %s", tree);
//
//        i=10;
//        tree.pop();
//        System.out.printf("\n== 删除元素: %d", i);
//        System.out.printf("\n== 最 小 堆: %s", tree);
//        System.out.printf("\n");
    }
    private List<T> mHeap;

    public MinHeap() {
        this.mHeap = new ArrayList<>();
    }
    /*
     * 最小堆的向下调整算法
     *
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     *
     * 参数说明：
     *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
     *     end   -- 截至范围(一般为数组中最后一个元素的索引)
     */
    private void sink(int start, int end) {
        int cur = start;
        while (cur <= end) {
            int left = 2 * cur + 1;
            int right = left + 1;
            int child = -1;
            if (left <= end && right <= end) {
                child = mHeap.get(left).compareTo(mHeap.get(right)) <= 0 ? left : right;
            } else if (left <= end) {
                child = left;
            } else {
                return;
            }
            if (mHeap.get(cur).compareTo(mHeap.get(child)) <= 0) {
                return;
            }
            swap(cur, child);
            cur = child;
        }
    }


    private void swap(int i, int j) {
        T tmp = mHeap.get(i);
        mHeap.set(i, mHeap.get(j));
        mHeap.set(j, tmp);
    }


    public T pop() {
        T res = mHeap.get(0);
        if (mHeap.size() > 1) {
            mHeap.set(0, mHeap.get(mHeap.size() - 1));
        }
        mHeap.remove(mHeap.size() - 1);
        sink(0, mHeap.size() - 1);
        return res;
    }


    private void swim(int start) {
        int cur = start;
        int parent = (cur - 1) / 2;
        T tmp = mHeap.get(cur);
        while (cur > 0) {
            int cmp = mHeap.get(parent).compareTo(tmp);
            if (cmp <= 0) {
                break;
            } else {
                mHeap.set(cur, mHeap.get(parent));
                cur = parent;
                parent = (cur - 1) / 2;
            }
        }
        mHeap.set(cur, tmp);
    }


    private void offer(T e) {
        int size = mHeap.size();
        mHeap.add(e);
        swim(size);
    }


    public boolean isEmpty() {
        return mHeap.isEmpty();
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<mHeap.size(); i++)
            sb.append(mHeap.get(i) +" ");

        return sb.toString();
    }

}
