package sword2offer;

import classes.TreeLinkNode;

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Q8 {
    public TreeLinkNode GetNext1(TreeLinkNode pNode)
    {
        if (pNode == null) return null;
        TreeLinkNode next = null;
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            next = pRight;
        } else if (pNode.next != null) {
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParrent = pNode.next;
            while (pParrent != null && pCurrent == pParrent.right) {
                pCurrent = pParrent;
                pParrent = pCurrent.next;
            }
            next = pParrent;
        }
        return next;
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) return null;
        TreeLinkNode next = null;
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            next = pRight;
        } else if (pNode.next != null) {
            if (pNode == pNode.next.left) {
                next = pNode.next;
            } else {
                TreeLinkNode pCurrent = pNode;
                TreeLinkNode pParrent = pNode.next;
                while (pParrent != null && pCurrent == pParrent.right) {
                    pCurrent = pParrent;
                    pParrent = pCurrent.next;
                }
                next = pParrent;
            }
        }
        return next;
    }
}
