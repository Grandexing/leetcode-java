package sword2offer;

import classes.ListNode;

public class Q52 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        int sub = length1 - length2;
        ListNode pHeadLong = pHead1;
        ListNode pHeadShort = pHead2;
        if (sub < 0) {
            pHeadLong = pHead2;
            pHeadShort = pHead1;
            sub = -sub;
        }
        for (int i = 0; i < sub; i++) {
            pHeadLong = pHeadLong.next;
        }
        while (pHeadLong != null && pHeadShort != null && pHeadLong != pHeadShort) {
            pHeadLong = pHeadLong.next;
            pHeadShort = pHeadShort.next;
        }
        ListNode pResult = pHeadLong;
        if (pHeadShort == null) {
            pResult = pHeadShort;
        }
        return pResult;
    }

    int getLength(ListNode pHead) {
        int length = 0;
        ListNode p = pHead;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }
}
