/**
 * Created by grande-xing on 2017/6/7.
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode left1=new TreeNode(2);
        TreeNode left2=new TreeNode(3);
        TreeNode right1=new TreeNode(4);
        TreeNode right2=new TreeNode(5);
        root.left=left1;
        left1.left=left2;
        left2.left=right1;
        right1.left=right2;
        scanNodes(root);
        System.out.println("树的深度是："+diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
//        return left > right ? left + 1:right + 1;
        return 1 + Math.max(left, right);
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
