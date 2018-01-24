package sword2offer;

import classes.ListNode;

/**
 * Created by grande on 2018/1/24.
 */
public class Q25 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode mergeHead = null;
        if (list1.val < list2.val) {
            mergeHead = list1;
            mergeHead.next = Merge(list1.next, list2);
        } else {
            mergeHead = list2;
            mergeHead.next = Merge(list1, list2.next);
        }
        return mergeHead;
    }
}
