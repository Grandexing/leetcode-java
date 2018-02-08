package sword2offer;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Q68 {
//    leetcode 236 二叉树的最低公共祖先

// 面试题68：树中两个结点的最低公共祖先
// 题目：输入两个树结点，求它们的最低公共祖先。


    public static void main(String[] args) {
        Q68 q68 = new Q68();
        q68.test();
    }

    public TreeNode getLastCommonParrent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        LinkedList<TreeNode> path1 = new LinkedList<>();
        LinkedList<TreeNode> path2 = new LinkedList<>();
        getNodePath(root, node1, path1);
        getNodePath(root, node2, path2);
        return getLastCommonNode(path1, path2);
    }


    private boolean getNodePath(TreeNode root, TreeNode node, LinkedList<TreeNode> path) {
        if (root == node) {
            return true;
        }
        path.add(root);
        boolean found = false;
        Iterator<TreeNode> children = root.children.iterator();
        while (!found && children.hasNext()) {
            found = getNodePath(children.next(), node, path);
        }
        if (!found) {
            path.removeLast();
        }
        return found;
    }


    private TreeNode getLastCommonNode(LinkedList<TreeNode> path1, LinkedList<TreeNode> path2) {
        showPath(path1);
        showPath(path2);
        Iterator<TreeNode> iterator1 = path1.iterator();
        Iterator<TreeNode> iterator2 = path2.iterator();
        TreeNode last = null;
        while (iterator1.hasNext() && iterator2.hasNext()) {
            TreeNode node1 = iterator1.next();
            TreeNode node2 = iterator2.next();
            if (node1 == node2) {
                last = node1;
            } else {
                break;
            }
        }
        return last;
    }


    private void showPath(LinkedList<TreeNode> path) {
        if (path == null) return;
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i).val);
            if (i != path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }


    void Test(String testName, TreeNode pRoot, TreeNode pNode1, TreeNode pNode2, TreeNode pExpected) {
        if (testName != null)
            System.out.println(String.format("%s begins: ", testName));

        TreeNode pResult = getLastCommonParrent(pRoot, pNode1, pNode2);
//        System.out.println(pResult.val);
        if ((pExpected == null && pResult == null) ||
                (pExpected != null && pResult != null && pResult.val == pExpected.val))
            System.out.println("Passed.\n");
        else
            System.out.println("Failed.\n");
    }

    // 形状普通的树
//              1
//            /   \
//           2     3
//       /       \
//      4         5
//     / \      / |  \
//    6   7    8  9  10
    void Test1() {
        TreeNode pNode1 = CreateTreeNode(1);
        TreeNode pNode2 = CreateTreeNode(2);
        TreeNode pNode3 = CreateTreeNode(3);
        TreeNode pNode4 = CreateTreeNode(4);
        TreeNode pNode5 = CreateTreeNode(5);
        TreeNode pNode6 = CreateTreeNode(6);
        TreeNode pNode7 = CreateTreeNode(7);
        TreeNode pNode8 = CreateTreeNode(8);
        TreeNode pNode9 = CreateTreeNode(9);
        TreeNode pNode10 = CreateTreeNode(10);

        ConnectTreeNodes(pNode1, pNode2);
        ConnectTreeNodes(pNode1, pNode3);

        ConnectTreeNodes(pNode2, pNode4);
        ConnectTreeNodes(pNode2, pNode5);

        ConnectTreeNodes(pNode4, pNode6);
        ConnectTreeNodes(pNode4, pNode7);

        ConnectTreeNodes(pNode5, pNode8);
        ConnectTreeNodes(pNode5, pNode9);
        ConnectTreeNodes(pNode5, pNode10);

        Test("Test1", pNode1, pNode6, pNode8, pNode2);
    }

    // 树退化成一个链表
//               1
//              /
//             2
//            /
//           3
//          /
//         4
//        /
//       5
    void Test2() {
        TreeNode pNode1 = CreateTreeNode(1);
        TreeNode pNode2 = CreateTreeNode(2);
        TreeNode pNode3 = CreateTreeNode(3);
        TreeNode pNode4 = CreateTreeNode(4);
        TreeNode pNode5 = CreateTreeNode(5);

        ConnectTreeNodes(pNode1, pNode2);
        ConnectTreeNodes(pNode2, pNode3);
        ConnectTreeNodes(pNode3, pNode4);
        ConnectTreeNodes(pNode4, pNode5);

        Test("Test2", pNode1, pNode5, pNode4, pNode3);
    }

    // 树退化成一个链表，一个结点不在树中
//               1
//              /
//             2
//            /
//           3
//          /
//         4
//        /
//       5
    void Test3() {
        TreeNode pNode1 = CreateTreeNode(1);
        TreeNode pNode2 = CreateTreeNode(2);
        TreeNode pNode3 = CreateTreeNode(3);
        TreeNode pNode4 = CreateTreeNode(4);
        TreeNode pNode5 = CreateTreeNode(5);

        ConnectTreeNodes(pNode1, pNode2);
        ConnectTreeNodes(pNode2, pNode3);
        ConnectTreeNodes(pNode3, pNode4);
        ConnectTreeNodes(pNode4, pNode5);

        TreeNode pNode6 = CreateTreeNode(6);

        Test("Test3", pNode1, pNode5, pNode6, null);
    }

    // 输入nullptr
    void Test4() {
        Test("Test4", null, null, null, null);
    }


    void test() {
        Test1();
        Test2();
        Test3();
        Test4();
    }


    TreeNode CreateTreeNode(int i) {
        return new TreeNode(i);
    }

    void ConnectTreeNodes(TreeNode root, TreeNode child) {
        if (root == null) return;
        root.children.add(child);
    }


    private class TreeNode {
        public int val;
        public HashSet<TreeNode> children;

        public TreeNode() {
            val = 0;
            children = new HashSet<>();
        }


        public TreeNode(int x) {
            val = x;
            children = new HashSet<>();
        }
    }
}
