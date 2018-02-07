package sword2offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q59Part2 {
// 面试题59（二）：队列的最大值
// 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
// 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
// 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，

    public static void main(String[] args) {
//        System.out.println(Integer.valueOf(-100).compareTo(Integer.valueOf(2)));
        Q59Part2 q59Part2 = new Q59Part2();
        q59Part2.test();
    }


    private class QueueWithMax<T extends Comparable> {
        Queue<InternalData<T>> queue;
        Deque<InternalData<T>> maxIndexQueue;
        int currentIndex;


        public QueueWithMax() {
            queue = new LinkedList<>();
            maxIndexQueue = new ArrayDeque<>();
            currentIndex = 0;
        }


        T max() {
            if (maxIndexQueue.isEmpty()) {
                return null;
            }
            return maxIndexQueue.peekFirst().number;
        }


        void pushBack(T number) {
            while (!maxIndexQueue.isEmpty() && less(maxIndexQueue.peekLast().number, number) ){
                maxIndexQueue.pollLast();
            }
            InternalData<T> data = new InternalData<>(number, currentIndex);
            maxIndexQueue.addLast(data);
            queue.add(data);
            currentIndex++;
        }


        T popFront() {
            if (queue.isEmpty()) {
                return null;
            }
            InternalData<T> delData = queue.poll();
            if (!maxIndexQueue.isEmpty() && maxIndexQueue.peekFirst().index == delData.index) {
                maxIndexQueue.pollFirst();
            }
            return delData.number;
        }


        private class InternalData<M extends Comparable> {
            M number;
            int index;


            public InternalData(M number, int index) {
                this.number = number;
                this.index = index;
            }
        }


        boolean less(T i1, T i2) {
            return i1.compareTo(i2) < 0;
        }
    }

    // ====================测试代码====================
    void Test(String testName, QueueWithMax<Integer> queue, int expected) {
        if (testName != null)
            System.out.println(String.format("%s begins: ", testName));
        System.out.println("max: " + queue.max());
        System.out.println("expected: " + expected);
        if (queue.max() == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("FAILED.\n");
    }

    void test() {
        QueueWithMax<Integer> queue = new QueueWithMax<>();
        // {2}
        queue.pushBack(2);
        Test("Test1", queue, 2);

        // {2, 3}
        queue.pushBack(3);
        Test("Test2", queue, 3);

        // {2, 3, 4}
        queue.pushBack(4);
        Test("Test3", queue, 4);

        // {2, 3, 4, 2}
        queue.pushBack(2);
        Test("Test4", queue, 4);

        // {3, 4, 2}
        queue.popFront();
        Test("Test5", queue, 4);

        // {4, 2}
        queue.popFront();
        Test("Test6", queue, 4);

        // {2}
        queue.popFront();
        Test("Test7", queue, 2);

        // {2, 6}
        queue.pushBack(6);
        Test("Test8", queue, 6);

        // {2, 6, 2}
        queue.pushBack(2);
        Test("Test9", queue, 6);

        // {2, 6, 2, 5}
        queue.pushBack(5);
        Test("Test9", queue, 6);

        // {6, 2, 5}
        queue.popFront();
        Test("Test10", queue, 6);

        // {2, 5}
        queue.popFront();
        Test("Test11", queue, 5);

        // {5}
        queue.popFront();
        Test("Test12", queue, 5);

        // {5, 1}
        queue.pushBack(1);
        Test("Test13", queue, 5);

    }
}
