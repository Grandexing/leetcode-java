package lintcode;

import classes.TreeNode;

import java.util.LinkedList;

public class Q7BinaryTreeSerialization {
//    http://www.lintcode.com/en/problem/binary-tree-serialization/#

    private static final String NULL_NODE_STR = "#";
    private static final String splitter = ",";

    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{}";
        }
        StringBuffer sb = new StringBuffer();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        while (queue.peekLast() == null) {
            queue.pollLast();
        }
        // root
        sb.append("{").append(queue.poll().val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(splitter).append(NULL_NODE_STR);
            } else {
                sb.append(splitter).append(node.val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        System.out.println(data.equals("{}"));
        if (data == null || data.isEmpty() || data.equals("{}")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(splitter);
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals(NULL_NODE_STR)) {
                TreeNode node = queue.get(index);
                TreeNode newNode = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    node.left = newNode;
                } else {
                    node.right = newNode;
                }
                queue.add(newNode);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}
