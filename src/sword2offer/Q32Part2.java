package sword2offer;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q32Part2 {
    public static void main(String[] args) {
        Q32Part2 q32Part2 = new Q32Part2();
        q32Part2.Test1();
        q32Part2.Test2();
        q32Part2.Test3();
        q32Part2.Test4();
        q32Part2.Test5();
        q32Part2.Test6();
    }


    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int toBePrint = 1;
        int nextLevel = 0;
        ArrayList<Integer> row = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            row.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            toBePrint--;
            if (toBePrint == 0) {
                toBePrint = nextLevel;
                nextLevel = 0;
                result.add(row);
                row = new ArrayList<>();
            }
        }
        return result;
    }


    void Print(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int toBePrint = 1;
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            toBePrint--;
            if (toBePrint == 0) {
                toBePrint = nextLevel;
                nextLevel = 0;
                System.out.println();
            }
        }
    }


    void ConnectTreeNodes(TreeNode root, TreeNode left, TreeNode right) {
        root.left = left;
        root.right = right;
    }


    void Test1() {
        TreeNode pNode8 = new TreeNode(8);
        TreeNode pNode6 = new TreeNode(6);
        TreeNode pNode10 = new TreeNode(10);
        TreeNode pNode5 = new TreeNode(5);
        TreeNode pNode7 = new TreeNode(7);
        TreeNode pNode9 = new TreeNode(9);
        TreeNode pNode11 = new TreeNode(11);

        ConnectTreeNodes(pNode8, pNode6, pNode10);
        ConnectTreeNodes(pNode6, pNode5, pNode7);
        ConnectTreeNodes(pNode10, pNode9, pNode11);

        System.out.print("====Test1 Begins: ====\n");
        System.out.print("Expected Result is:\n");
        System.out.print("8 \n");
        System.out.print("6 10 \n");
        System.out.print("5 7 9 11 \n\n");

        System.out.print("Actual Result is: \n");
        Print(pNode8);
        System.out.print("\n");


    }

    //            5
//          4
//        3
//      2
    void Test2() {
        TreeNode pNode5 = new TreeNode(5);
        TreeNode pNode4 = new TreeNode(4);
        TreeNode pNode3 = new TreeNode(3);
        TreeNode pNode2 = new TreeNode(2);

        ConnectTreeNodes(pNode5, pNode4, null);
        ConnectTreeNodes(pNode4, pNode3, null);
        ConnectTreeNodes(pNode3, pNode2, null);

        System.out.print("====Test2 Begins: ====\n");
        System.out.print("Expected Result is:\n");
        System.out.print("5 \n");
        System.out.print("4 \n");
        System.out.print("3 \n");
        System.out.print("2 \n\n");

        System.out.print("Actual Result is: \n");
        Print(pNode5);
        System.out.print("\n");


    }

    //        5
//         4
//          3
//           2
    void Test3() {
        TreeNode pNode5 = new TreeNode(5);
        TreeNode pNode4 = new TreeNode(4);
        TreeNode pNode3 = new TreeNode(3);
        TreeNode pNode2 = new TreeNode(2);

        ConnectTreeNodes(pNode5, null, pNode4);
        ConnectTreeNodes(pNode4, null, pNode3);
        ConnectTreeNodes(pNode3, null, pNode2);

        System.out.print("====Test3 Begins: ====\n");
        System.out.print("Expected Result is:\n");
        System.out.print("5 \n");
        System.out.print("4 \n");
        System.out.print("3 \n");
        System.out.print("2 \n\n");

        System.out.print("Actual Result is: \n");
        Print(pNode5);
        System.out.print("\n");


    }

    void Test4() {
        TreeNode pNode5 = new TreeNode(5);

        System.out.print("====Test4 Begins: ====\n");
        System.out.print("Expected Result is:\n");
        System.out.print("5 \n\n");

        System.out.print("Actual Result is: \n");
        Print(pNode5);
        System.out.print("\n");


    }

    void Test5() {
        System.out.print("====Test5 Begins: ====\n");
        System.out.print("Expected Result is:\n");

        System.out.print("Actual Result is: \n");
        Print(null);
        System.out.print("\n");
    }

    //        100
//        /
//       50   
//         \
//         150
    void Test6() {
        TreeNode pNode100 = new TreeNode(100);
        TreeNode pNode50 = new TreeNode(50);
        TreeNode pNode150 = new TreeNode(150);

        ConnectTreeNodes(pNode100, pNode50, null);
        ConnectTreeNodes(pNode50, null, pNode150);

        System.out.print("====Test6 Begins: ====\n");
        System.out.print("Expected Result is:\n");
        System.out.print("100 \n");
        System.out.print("50 \n");
        System.out.print("150 \n\n");

        System.out.print("Actual Result is: \n");
        Print(pNode100);
        System.out.print("\n");
    }
}
