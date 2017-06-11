/**
 * Created by grande-xing on 2017/6/7.
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
        root.left=node1;
        node1.left=node2;
        node2.left=node3;
        node3.left=node4;
        scanNodes(root);
        System.out.println("树的深度是："+diameterOfBinaryTree(root));
    }
    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

    static void scanNodes(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val); //先序遍历
        scanNodes(root.left);
        //System.out.println(root.val); 中序遍历
        scanNodes(root.right);
        //System.out.println(root.val); 后序遍历
    }
}
