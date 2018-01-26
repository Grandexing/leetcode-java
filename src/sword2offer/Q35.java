package sword2offer;

import classes.RandomListNode;

public class Q35 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) return null;
        cloneNodes(pHead);
        cloneRandomLinks(pHead);
        RandomListNode pHeadClone = splitCloneList(pHead);
        return pHeadClone;
    }

    void cloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pNext = pNode.next;
            RandomListNode pClone = new RandomListNode(pNode.label);
            pNode.next = pClone;
            pClone.next = pNext;
            pNode = pNext;
        }
    }

    void cloneRandomLinks(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null && pNode.next != null) {
            RandomListNode pClone = pNode.next;
            RandomListNode pNext = pClone.next;
            if (pNode.random != null && pNode.random.next != null) {
                pClone.random = pNode.random.next;
            }
            pNode = pNext;
        }
    }

    RandomListNode splitCloneList(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pNodeClone = pHead.next;
        RandomListNode pHeadClone = pHead.next;
        while (pNodeClone.next != null) {
            pNode.next = pNodeClone.next;
            pNodeClone.next = pNodeClone.next.next;
            pNode = pNode.next;
            pNodeClone = pNodeClone.next;
        }
        pNode.next = null;
        pNodeClone.next = null;
        return pHeadClone;
    }
}
