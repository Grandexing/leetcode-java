package sword2offer;

import classes.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Q37 {
    private static final String spliter = ",";
    private static final String NN = "$";


    public static void main(String[] args) {
        Q37 q37 = new Q37();
        String s = "1,2,4,$,$,$,3,5,$,$,6,$,$";
        System.out.println(q37.Serialize(q37.Deserialize(s)));
    }


    String Serialize(TreeNode root) {
        if (root == null) return null;
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.substring(0, sb.length() - 1);
    }


    void serialize(TreeNode pNode, StringBuffer sb) {
        if (pNode == null) {
            sb.append(NN).append(spliter);
            return;
        }
        sb.append(pNode.val).append(spliter);
        serialize(pNode.left, sb);
        serialize(pNode.right,sb);
    }


    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0 || str.split(",").length == 0) return null;
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(str.split(",")));
        return deserialize(nodes);
    }


    TreeNode deserialize(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        TreeNode pNode = new TreeNode(Integer.parseInt(val));
        pNode.left = deserialize(nodes);
        pNode.right = deserialize(nodes);
        return pNode;
    }


    Integer getNumber(String s) {
        if (s.equals("$")) {
            return null;
        }
        return Integer.parseInt(s);
    }



}
