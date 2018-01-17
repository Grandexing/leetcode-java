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
    public TreeLinkNode GetNext2(TreeLinkNode pNode)
    {
        if (pNode == null) return null;
        TreeLinkNode next = null;
        if (pNode.right != null) {
            //有右子树，下一个节点为右子树的最左叶子
            next = findMostLeftLeaf(pNode.right);
        } else if (pNode.next != null){
            //无右子树，且不是根节点
            TreeLinkNode pCurrent, pParrent;
            pCurrent = pNode;
            pParrent = pNode.next;
            while (pParrent != null && pCurrent != pParrent.left) {
                pCurrent = pParrent;
                pParrent = pCurrent.next;
            }
            next = pParrent;
        }
        return next;
    }

    public TreeLinkNode findMostLeftLeaf(TreeLinkNode pNode) {
        if (pNode == null) return null;
        TreeLinkNode pLeft = pNode;
        while(pLeft.left != null) {
            pLeft = pLeft.left;
        }
        return pLeft;
    }


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
