package sword2offer;

import java.util.*;

public class Q40 {
    public static void main(String[] args) {
        Q40 q40 = new Q40();
        int[] array = {4,5,1,6,2,7,3,8};
        System.out.println(q40.GetLeastNumbers_Solution_v2(array, 4));
    }


    public ArrayList<Integer> GetLeastNumbers_Solution_v2(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) return result;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (queue.size() < k) {
                queue.add(input[i]);
            } else {
                int peek = queue.peek();
                System.out.println(peek);
                if (peek > input[i]) {
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }
        result.addAll(queue);
        return result;
    }


    Random random = new Random();


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) return result;
        int lo = 0;
        int hi = input.length - 1;
        int index = partition(input, lo, hi);
        while (index != k - 1) {
            if (index > k - 1) {
                hi = index - 1;
                index = partition(input, lo, hi);
            } else {
                lo = index + 1;
                index = partition(input, lo, hi);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }


    int partition(int[] array, int lo, int hi) {
        if (lo == hi) return lo;
        int j = random.nextInt(hi - lo + 1) + lo;
        swap(array, j, hi);
        int small = lo - 1;
        for (int i = lo; i < hi; i++) {
            if (array[i] < array[hi]) {
                small++;
                if (small != i) {
                    swap(array, small, i);
                }
            }
        }
        small++;
        swap(array, small, hi);
        return small;
    }


    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
