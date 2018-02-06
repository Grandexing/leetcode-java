package sword2offer;

import classes.TreeNode;

import java.util.Stack;

public class Q54 {
// 面试题54：二叉搜索树的第k个结点
// 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。

    public static void main(String[] args) {
        Q54 q54 = new Q54();
        q54.test();
    }


    TreeNode KthNode1(TreeNode pRoot, int k) {
        //非递归版
        if (pRoot == null || k == 0) {
            return null;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = pRoot;
        while (pNode != null || !stack.isEmpty()) {
            while (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            }
            pNode = stack.pop();
            count++;
            if (count == k) {
                return pNode;
            }
            pNode = pNode.right;
        }
        return null;
    }


    int k;

    TreeNode KthNode(TreeNode pRoot, int k) {
        //考察二叉树的中序遍历
        if (pRoot == null || k == 0) {
            return null;
        }
        this.k = k;
        return KthNodeRec(pRoot);
    }


    TreeNode KthNodeRec(TreeNode pRoot) {
        TreeNode target = null;
        if (pRoot.left != null) {
            target = KthNodeRec(pRoot.left);
        }
        if (target == null) {
            if (k == 1) {
                target = pRoot;
            }
            k--;
        }
        if (target == null && pRoot.right != null) {
            target = KthNodeRec(pRoot.right);
        }
        return target;
    }


    void Test(String testName, TreeNode pRoot, int k, boolean isNull, int expected) {
        if (testName != null)
            System.out.println(String.format("%s begins: ", testName));
        TreeNode pTarget = KthNode1(pRoot, k);
        if (pTarget != null) System.out.println(pTarget.val);
        if ((isNull && pTarget == null) || (!isNull && pTarget.val == expected))
            System.out.println("Passed.\n");
        else
            System.out.println("FAILED.\n");
    }

//            8
//        6      10
//       5 7    9  11
    void TestA() {
        TreeNode pNode8 = CreateTreeNode(8);
        TreeNode pNode6 = CreateTreeNode(6);
        TreeNode pNode10 = CreateTreeNode(10);
        TreeNode pNode5 = CreateTreeNode(5);
        TreeNode pNode7 = CreateTreeNode(7);
        TreeNode pNode9 = CreateTreeNode(9);
        TreeNode pNode11 = CreateTreeNode(11);

        ConnectTreeNodes(pNode8, pNode6, pNode10);
        ConnectTreeNodes(pNode6, pNode5, pNode7);
        ConnectTreeNodes(pNode10, pNode9, pNode11);

        Test("TestA0", pNode8, 0, true, -1);
        Test("TestA1", pNode8, 1, false, 5);
        Test("TestA2", pNode8, 2, false, 6);
        Test("TestA3", pNode8, 3, false, 7);
        Test("TestA4", pNode8, 4, false, 8);
        Test("TestA5", pNode8, 5, false, 9);
        Test("TestA6", pNode8, 6, false, 10);
        Test("TestA7", pNode8, 7, false, 11);
        Test("TestA8", pNode8, 8, true, -1);
        System.out.println("\n\n");
    }

    //               5
//              /
//             4
//            /
//           3
//          /
//         2
//        /
//       1
    void TestB() {
        TreeNode pNode5 = CreateTreeNode(5);
        TreeNode pNode4 = CreateTreeNode(4);
        TreeNode pNode3 = CreateTreeNode(3);
        TreeNode pNode2 = CreateTreeNode(2);
        TreeNode pNode1 = CreateTreeNode(1);

        ConnectTreeNodes(pNode5, pNode4, null);
        ConnectTreeNodes(pNode4, pNode3, null);
        ConnectTreeNodes(pNode3, pNode2, null);
        ConnectTreeNodes(pNode2, pNode1, null);

        Test("TestB0", pNode5, 0, true, -1);
        Test("TestB1", pNode5, 1, false, 1);
        Test("TestB2", pNode5, 2, false, 2);
        Test("TestB3", pNode5, 3, false, 3);
        Test("TestB4", pNode5, 4, false, 4);
        Test("TestB5", pNode5, 5, false, 5);
        Test("TestB6", pNode5, 6, true, -1);


        System.out.println("\n\n");
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
    void TestC() {
        TreeNode pNode1 = CreateTreeNode(1);
        TreeNode pNode2 = CreateTreeNode(2);
        TreeNode pNode3 = CreateTreeNode(3);
        TreeNode pNode4 = CreateTreeNode(4);
        TreeNode pNode5 = CreateTreeNode(5);

        ConnectTreeNodes(pNode1, null, pNode2);
        ConnectTreeNodes(pNode2, null, pNode3);
        ConnectTreeNodes(pNode3, null, pNode4);
        ConnectTreeNodes(pNode4, null, pNode5);

        Test("TestC0", pNode1, 0, true, -1);
        Test("TestC1", pNode1, 1, false, 1);
        Test("TestC2", pNode1, 2, false, 2);
        Test("TestC3", pNode1, 3, false, 3);
        Test("TestC4", pNode1, 4, false, 4);
        Test("TestC5", pNode1, 5, false, 5);
        Test("TestC6", pNode1, 6, true, -1);


        System.out.println("\n\n");
    }

    // There is only one node in a tree
    void TestD() {
        TreeNode pNode1 = CreateTreeNode(1);

        Test("TestD0", pNode1, 0, true, -1);
        Test("TestD1", pNode1, 1, false, 1);
        Test("TestD2", pNode1, 2, true, -1);


        System.out.println("\n\n");
    }

    // empty tree
    void TestE() {
        Test("TestE0", null, 0, true, -1);
        Test("TestE1", null, 1, true, -1);

        System.out.println("\n\n");
    }

    void test() {
        TestA();
        TestB();
        TestC();
        TestD();
        TestE();
    }


    private TreeNode CreateTreeNode(int i) {
        return new TreeNode(i);
    }

    void ConnectTreeNodes(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) return;
        root.left = left;
        root.right = right;
    }
}
