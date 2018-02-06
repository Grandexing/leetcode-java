package classes;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(){}


    public TreeNode(int x) {
        val = x;
    }


    public static TreeNode CreateTreeNode(int i) {
        return new TreeNode(i);
    }

    public static void ConnectTreeNodes(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) return;
        root.left = left;
        root.right = right;
    }
}
