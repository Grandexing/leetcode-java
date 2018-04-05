package bishi.threesixzero;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        number of node
        int n = scanner.nextInt();
//        number of edge
        int m = scanner.nextInt();
        long k = scanner.nextLong();
        HashMap<Integer, TreeNode> map0 = new HashMap<>();
        HashMap<Integer, TreeNode> map1 = new HashMap<>();
        TreeNode root0 = new TreeNode(0);
        TreeNode root1 = new TreeNode(1);
        map0.put(0, root0);
        map1.put(1, root1);
        for (int i = 0; i < m; i++) {
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            if ((a1 == 0 && a2 == 1) || (a1 == 1 && a2 == 0)) {
                continue;
            }
            if (a1 == 0 || map0.containsKey(a1)) {
                TreeNode node = new TreeNode(a2);
                TreeNode node1 = map0.get(a1);
                node1.children.add(node);
                node.fathers.add(node1);
                map0.put(a2, node);
            }
        }
    }


}


class TreeNode {
    HashSet<TreeNode> fathers;
    int val;
    HashSet<TreeNode> children;
    TreeNode (int val) {
        this.val = val;
        children = new HashSet<>();
        fathers = new HashSet<>();
    }
}