package sword2offer;

import classes.ListNode;

import static sword2offer.Q18Part1.DeleteNode;

public class Q18Part1 {
    public static void main(String[] args) {
        Test4Q18 test = new Test4Q18();
        test.Test1();
        test.Test2();
        test.Test3();
        test.Test4();
        test.Test5();
    }


    static void DeleteNode(ListNode pListHead, ListNode pNode) {
        if (pNode == null || pListHead == null) {
            return;
        }
        if (pNode.next != null) {
            pNode.val = pNode.next.val;
            pNode.next = pNode.next.next;
        } else if (pListHead == pNode) {
//            要删除的是头节点，且链表只有一个节点，这里无法删除？
            pNode = null;
            pListHead = null;
        } else {
//            p是尾节点，需要找到p的前一个节点
            ListNode p = pListHead;
            while (p.next != pNode) {
                p = p.next;
            }
            p.next = null;
        }

    }
}

class Test4Q18 {
    void ConnectListNodes(ListNode p1, ListNode p2) {
        if (p1 == null) return;
        p1.next = p2;
    }

    void Test(ListNode pListHead, ListNode pNode)
    {
        System.out.println("The original list is: \n");
        PrintList(pListHead);

        System.out.println("The node to be deleted is: \n");
        PrintListNode(pNode);

        DeleteNode(pListHead, pNode);
        System.out.println("The result list is: \n");
        PrintList(pListHead);
    }

    private void PrintList(ListNode pListHead) {
        if (pListHead == null) {
            System.out.println("null");
            return;
        }
        ListNode p = pListHead;
        while (p != null) {
            PrintListNode(p);
            p = p.next;
        }
    }


    private void PrintListNode(ListNode pNode) {
        if (pNode == null) {
            System.out.println("null");
            return;
        }
        System.out.println(pNode.val);
    }

    // 链表中有多个结点，删除中间的结点
    void Test1()
    {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ConnectListNodes(pNode1, pNode2);
        ConnectListNodes(pNode2, pNode3);
        ConnectListNodes(pNode3, pNode4);
        ConnectListNodes(pNode4, pNode5);
        Test(pNode1, pNode3);
    }

    // 链表中有多个结点，删除尾结点
    void Test2()
    {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ConnectListNodes(pNode1, pNode2);
        ConnectListNodes(pNode2, pNode3);
        ConnectListNodes(pNode3, pNode4);
        ConnectListNodes(pNode4, pNode5);
        Test(pNode1, pNode5);
    }

    // 链表中有多个结点，删除头结点
    void Test3()
    {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        ConnectListNodes(pNode1, pNode2);
        ConnectListNodes(pNode2, pNode3);
        ConnectListNodes(pNode3, pNode4);
        ConnectListNodes(pNode4, pNode5);

        Test(pNode1, pNode1);

    }

    // 链表中只有一个结点，删除头结点
    void Test4()
    {
        ListNode pNode1 = new ListNode(1);

        Test(pNode1, pNode1);
    }

    // 链表为空
    void Test5()
    {
        Test(null, null);
    }
}