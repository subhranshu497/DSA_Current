package com.prep.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalIteration {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> results = levelOrderTraversalTwo(root);
        for(List<Integer> list : results){
            System.out.print(list+", ");
        }
    }

    private static List<List<Integer>> levelOrderTraversalTwo(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root==null) return results;
        int level =0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int len = q.size();
            results.add(new ArrayList<>());
            for(int i=0;i<len;i++){
                TreeNode node = q.remove();
                results.get(level).add(node.val);
                if(node.left !=null)q.add(node.left);
                if(node.right !=null)q.add(node.right);
            }
            level++;
        }
        return results;
    }
}
