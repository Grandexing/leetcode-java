package lintcode;

import classes.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q104MergekSortedLists {
//    http://www.lintcode.com/en/problem/merge-k-sorted-lists/

    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.isEmpty()) {
            return null;
        }
        // return merge(lists, 0, lists.size() - 1);
        return mergeByHeap(lists);
    }


    private Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    };
    private ListNode mergeByHeap(List<ListNode> lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.size(), listNodeComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                heap.add(node.next);
            }
        }
        return dummy.next;
    }


    private ListNode merge(List<ListNode> lists, int start, int end) {
        if (start >= end) {
            return lists.get(start);
        }
        int middle = start + (end - start) / 2;
        ListNode left = merge(lists, start, middle);
        ListNode right = merge(lists, middle + 1, end);
        return mergeTwoSortList(left, right);
    }


    private ListNode mergeTwoSortList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        while (list1 != null && list2 != null) {
            if (list2.val > list1.val) {
                curt.next = list1;
                list1 = list1.next;
            } else {
                curt.next = list2;
                list2 = list2.next;
            }
            curt = curt.next;
        }
        if (list1 != null) {
            curt.next = list1;
        } else if (list2 != null) {
            curt.next = list2;
        }
        return dummy.next;
    }
}
