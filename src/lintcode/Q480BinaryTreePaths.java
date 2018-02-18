package lintcode;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q480BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        binaryTreePaths(root, new ArrayList<>(), paths);
        return paths;
    }


    private void binaryTreePaths(TreeNode root, List<TreeNode> path, List<String> paths) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root.left == null && root.right == null) {
            String pathStr = mkString(path);
            paths.add(pathStr);
            path.remove(path.size() - 1);
            return;
        }
        if (root.left != null) {
            binaryTreePaths(root.left, path, paths);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, path, paths);
        }
        path.remove(path.size() - 1);
    }


    private String mkString(List<TreeNode> path) {
        System.out.println("size: "+path.size());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i).val);
            if (i != path.size() - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
