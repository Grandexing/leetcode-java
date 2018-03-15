package classes;

import java.util.ArrayList;

/**
 * Created by grande on 2018/3/15.
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
}