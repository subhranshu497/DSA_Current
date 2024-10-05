package com.prep.leetcode150.graphGeneral;

import java.util.*;

public class LNum133CloneGraph {
    public Node cloneGraph(Node node){
        Node cloneNode = new Node(node.val);
        //traverse the existing node to find out the neighbors
        //store the existing node and clone node in a map
        //dfs
        Map<Node, Node> map = new HashMap<>();
        map.put(node, cloneNode);
        //cloneNodeDFS(node, cloneNode, map);
        //with BFS
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        cloneNodeBFS(q, map);
        return cloneNode;
    }
        private void cloneNodeBFS(Queue<Node> q, Map<Node, Node> map) {
            while (!q.isEmpty()){
                Node node = q.poll();
                Node cloneNode = map.get(node);
                for(Node n: node.neighbors){
                    if(!map.containsKey(n)){
                        Node clone = new Node(n.val);
                        map.put(n,clone);
                        cloneNode.neighbors.add(clone);
                        q.add(n);
                    }
                    else{
                        cloneNode.neighbors.add(map.get(n));
                    }
                }
            }
        }

    private void cloneNodeDFS(Node node, Node cloneNode, Map<Node, Node> map) {
        for(Node n: node.neighbors){
            if(!map.containsKey(n)){
                Node clone = new Node(n.val);
                map.put(n, clone);
                cloneNode.neighbors.add(clone);
                cloneNodeDFS(n, clone, map);
            }
            else{
                cloneNode.neighbors.add(map.get(n));
            }
        }
    }
}
class Node{
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
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
