package sword2offer;

import classes.TreeNode;

public class Q36 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode lastNodeInList = null;
        lastNodeInList = convert(pRootOfTree, lastNodeInList);
        TreeNode headOfList = lastNodeInList;
        while (headOfList.left != null) {
            headOfList = headOfList.left;
        }
        return headOfList;
    }


    public TreeNode convert(TreeNode pNode, TreeNode lastNodeInList) {
        if (pNode == null) return lastNodeInList;
        if (pNode.left != null) {
            lastNodeInList = convert(pNode.left, lastNodeInList);
        }
        pNode.left = lastNodeInList;
        if (lastNodeInList != null) {
            lastNodeInList.right = pNode;
        }
        lastNodeInList = pNode;
        if (pNode.right != null) {
            lastNodeInList = convert(pNode.right, lastNodeInList);
        }
        return lastNodeInList;
    }
}
