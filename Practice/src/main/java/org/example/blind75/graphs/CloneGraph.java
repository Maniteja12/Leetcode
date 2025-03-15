package org.example.blind75.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CloneGraph {
        public Node cloneGraph(Node node) {
            HashMap<Node, Node> newG = new HashMap<>();
            if(node == null){
                return node;
            }
            if(newG.containsKey(node)){
                return newG.get(node);
            }
            var y = new Node();
            y.val = node.val;
            newG.put(node, y);
            y.neighbors = node.neighbors.stream().map(this::cloneGraph).collect(Collectors.toList());

            return y;
        }
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}