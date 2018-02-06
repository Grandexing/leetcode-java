package sword2offer;

import classes.TreeNode;

import static classes.TreeNode.ConnectTreeNodes;
import static classes.TreeNode.CreateTreeNode;

public class Q55Part2 {

// 面试题55（二）：平衡二叉树
// 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中
// 任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

    public static void main(String[] args) {
        Q55Part2 q55Part2 = new Q55Part2();
        q55Part2.test();
    }


    public boolean IsBalanced_Solution(TreeNode root) {
        Holder depth = new Holder();
        return isBalanced(root, depth);
    }


    private class Holder {
        int val;
    }



    boolean isBalanced(TreeNode root, Holder depth) {
        if (root == null) {
            depth.val = 0;
            return true;
        }
        Holder left = new Holder();
        Holder right = new Holder();
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = left.val - right.val;
            if (diff <= 1 && diff >= -1) {
                depth.val = 1 + (left.val > right.val ? left.val : right.val);
                return true;
            }
        }
        return false;
    }


    // ====================测试代码====================
    void Test(String testName, TreeNode pRoot, boolean expected) {
        if (testName != null)
            System.out.println(String.format("%s begins:\n", testName));

        System.out.println("Solution1 begins: ");
        if (IsBalanced_Solution(pRoot) == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("Failed.\n");
    }

// 完全二叉树
//             1
//         /      \
//        2        3
//       /\       / \
//      4  5     6   7
    void Test1() {
        TreeNode pNode1 = CreateTreeNode(1);
        TreeNode pNode2 = CreateTreeNode(2);
        TreeNode pNode3 = CreateTreeNode(3);
        TreeNode pNode4 = CreateTreeNode(4);
        TreeNode pNode5 = CreateTreeNode(5);
        TreeNode pNode6 = CreateTreeNode(6);
        TreeNode pNode7 = CreateTreeNode(7);

        ConnectTreeNodes(pNode1, pNode2, pNode3);
        ConnectTreeNodes(pNode2, pNode4, pNode5);
        ConnectTreeNodes(pNode3, pNode6, pNode7);

        Test("Test1", pNode1, true);


    }

// 不是完全二叉树，但是平衡二叉树
//             1
//         /      \
//        2        3
//       /\         \
//      4  5         6
//        /
//       7
    void Test2() {
        TreeNode pNode1 = CreateTreeNode(1);
        TreeNode pNode2 = CreateTreeNode(2);
        TreeNode pNode3 = CreateTreeNode(3);
        TreeNode pNode4 = CreateTreeNode(4);
        TreeNode pNode5 = CreateTreeNode(5);
        TreeNode pNode6 = CreateTreeNode(6);
        TreeNode pNode7 = CreateTreeNode(7);

        ConnectTreeNodes(pNode1, pNode2, pNode3);
        ConnectTreeNodes(pNode2, pNode4, pNode5);
        ConnectTreeNodes(pNode3, null, pNode6);
        ConnectTreeNodes(pNode5, pNode7, null);

        Test("Test2", pNode1, true);


    }

// 不是平衡二叉树
//             1
//         /      \
//        2        3
//       /\
//      4  5
//        /
//       6
    void Test3() {
        TreeNode pNode1 = CreateTreeNode(1);
        TreeNode pNode2 = CreateTreeNode(2);
        TreeNode pNode3 = CreateTreeNode(3);
        TreeNode pNode4 = CreateTreeNode(4);
        TreeNode pNode5 = CreateTreeNode(5);
        TreeNode pNode6 = CreateTreeNode(6);

        ConnectTreeNodes(pNode1, pNode2, pNode3);
        ConnectTreeNodes(pNode2, pNode4, pNode5);
        ConnectTreeNodes(pNode5, pNode6, null);

        Test("Test3", pNode1, false);


    }


//               1
//              /
//             2
//            /
//           3
//          /
//         4
//        /
//       5
    void Test4() {
        TreeNode pNode1 = CreateTreeNode(1);
        TreeNode pNode2 = CreateTreeNode(2);
        TreeNode pNode3 = CreateTreeNode(3);
        TreeNode pNode4 = CreateTreeNode(4);
        TreeNode pNode5 = CreateTreeNode(5);

        ConnectTreeNodes(pNode1, pNode2, null);
        ConnectTreeNodes(pNode2, pNode3, null);
        ConnectTreeNodes(pNode3, pNode4, null);
        ConnectTreeNodes(pNode4, pNode5, null);

        Test("Test4", pNode1, false);


    }

// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
    void Test5() {
        TreeNode pNode1 = CreateTreeNode(1);
        TreeNode pNode2 = CreateTreeNode(2);
        TreeNode pNode3 = CreateTreeNode(3);
        TreeNode pNode4 = CreateTreeNode(4);
        TreeNode pNode5 = CreateTreeNode(5);

        ConnectTreeNodes(pNode1, null, pNode2);
        ConnectTreeNodes(pNode2, null, pNode3);
        ConnectTreeNodes(pNode3, null, pNode4);
        ConnectTreeNodes(pNode4, null, pNode5);

        Test("Test5", pNode1, false);


    }

    // 树中只有1个结点
    void Test6() {
        TreeNode pNode1 = CreateTreeNode(1);
        Test("Test6", pNode1, true);


    }

    // 树中没有结点
    void Test7() {
        Test("Test7", null, true);
    }

    void test() {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();

    }
}
