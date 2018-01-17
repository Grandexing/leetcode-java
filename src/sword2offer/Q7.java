package sword2offer;

import classes.TreeNode;

public class Q7 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in)  throws Exception {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) return null;
        return constructCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }


    private TreeNode constructCore1(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                root.left = constructCore1(pre, in, preStart + 1, preStart + i - inStart, inStart, i - 1);
                root.right = constructCore1(pre, in, preStart + i - inStart + 1, preEnd, i + 1, inEnd);
                break;
            }
        }
        return root;
    }


    private TreeNode constructCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) throws Exception {
        //从前序遍历中找到根节点
        int rootValue = pre[preStart];
        TreeNode root = new TreeNode(rootValue);
        if (preStart == preEnd) {
            if (inStart == inEnd && in[inStart] == rootValue) {
                return root;
            } else {
                throw new Exception("invalid input");
            }
        }
        //从中序遍历中找到根节点
        int inRoot = inStart;
        while (in[inRoot] != rootValue) {
            inRoot++;
        }
        if (inRoot == inEnd && in[inRoot] != rootValue) {
            throw new Exception("invalid input");
        }
        int leftLength = inRoot - inStart;
        int preLeftEnd = preStart + leftLength;
        if (leftLength > 0) {
            //构建左子树
            root.left = constructCore(pre, in, preStart + 1, preLeftEnd, inStart, inRoot - 1);
        }
        if (leftLength < inEnd - inStart) {
            //构建右子树
            root.right = constructCore(pre, in, preLeftEnd + 1, preEnd, inRoot + 1, inEnd);
        }
        return root;
    }
}
