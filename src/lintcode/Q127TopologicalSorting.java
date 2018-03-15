package lintcode;

import classes.DirectedGraphNode;

import java.util.*;

/**
 * Created by grande on 2018/3/15.
 */
public class Q127TopologicalSorting {
//    https://github.com/Grandexing/leetcode-java.git
public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    // write your code here
    ArrayList<DirectedGraphNode> result = new ArrayList<>();
    if (graph == null || graph.isEmpty()) {
        return result;
    }
    HashMap<DirectedGraphNode, Integer> neighborMap = new HashMap<>();
    for (DirectedGraphNode node : graph) {
        List<DirectedGraphNode> neighbors = node.neighbors;
        for (DirectedGraphNode neighbor : neighbors) {
            if (neighborMap.containsKey(neighbor)) {
                neighborMap.put(neighbor, neighborMap.get(neighbor) + 1);
            } else {
                neighborMap.put(neighbor, 1);
            }
        }
    }
    Queue<DirectedGraphNode> queue = new LinkedList<>();
    for (DirectedGraphNode node : graph) {
        if (!neighborMap.containsKey(node)) {
            queue.offer(node);
        }
    }
    while (!queue.isEmpty()) {
        DirectedGraphNode node = queue.poll();
        result.add(node);
        for (DirectedGraphNode neighbor : node.neighbors) {
            neighborMap.put(neighbor, neighborMap.get(neighbor) - 1);
            if (neighborMap.get(neighbor) == 0) {
                queue.offer(neighbor);
            }
        }
    }
    return result;
}
}
