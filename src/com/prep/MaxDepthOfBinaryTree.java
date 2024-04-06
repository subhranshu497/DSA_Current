package com.prep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levels =0;
        while(true){
            int nodeCount = q.size();
            if(nodeCount == 0) return levels;
            while(nodeCount >0){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                nodeCount--;
            }
            levels++;
        }
    }
    private static void levelOrderTrav(TreeNode root){
        int count =0;
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = false;
        if(root != null){
            q.offer(root);
            count++;
        }
        while (!q.isEmpty()){
            TreeNode node = q.peek();
            if(node.left != null){
                q.offer(node.left);
                flag = true;
            }
            if(node.right !=null){
                q.offer(node.right);
                flag = true;
            }
            q.poll();
            if(flag)count++;
        }
    }

}

