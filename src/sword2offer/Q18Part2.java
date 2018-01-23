package sword2offer;

import classes.ListNode;

public class Q18Part2 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null) return null;
        ListNode pPre = null;
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if (pNext != null && pNode.val == pNext.val) {
                needDelete = true;
            }
            if (!needDelete) {
                pPre = pNode;
                pNode = pNode.next;
            } else {
                int sameVal = pNode.val;
                ListNode pToBeDel = pNode;
                while (pToBeDel != null && pToBeDel.val == sameVal) {
                    pNext = pToBeDel.next;
                    pToBeDel = null;
                    pToBeDel = pNext;
                }
                if (pPre == null) {
                    pHead = pNext;
                } else {
                    pPre.next = pNext;
                }
                pNode = pNext;
            }
        }
        return pHead;
    }
}
