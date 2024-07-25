package com.prep.meta;

import com.prep.MinimumNumberOfOperationsToMakeArrayXOREqualToK;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> results = verticalOrder(root);
        for(List<Integer> list:results){
            System.out.println(list+", ");
        }
    }

    private static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //edge case
        if(root==null) return result;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        Queue<NodeAndHd> q = new LinkedList<>();
        q.offer(new NodeAndHd(root,0));
        while(!q.isEmpty()){
            NodeAndHd node = q.poll();
            map.putIfAbsent(node.x, new ArrayList<>());
            map.get(node.x).add(node.root.val);
            minX = Math.min(minX, node.x);
            maxX = Math.max(maxX, node.x);
            if(node.root.left != null){
                q.offer(new NodeAndHd(node.root.left, node.x-1));
            }
            if(node.root.right !=null){
                q.offer(new NodeAndHd(node.root.right, node.x+1));
            }
        }
        for(int i=minX;i<=maxX;i++){
            List<Integer> tempList = map.get(i);
            result.add(tempList);
        }
        return result;
    }
}
class NodeAndHd{
    TreeNode root;
    int x;
    public NodeAndHd(TreeNode root, int x){
        this.root = root;
        this.x = x;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode right, TreeNode left){
        this.val = val;
        this.right = right;
        this.left= left;
    }
}
