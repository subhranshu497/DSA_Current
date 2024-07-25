package com.prep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HeightOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int height = heightOfBTree(root);
        System.out.println(height);
    }

    //using BFS
    private static int heightOfBTree(TreeNode root) {
        int noOfLevels = -1;
        Queue<TreeNode> q = new LinkedList<>();
        if(root !=null){
            q.add(root);
            noOfLevels++;
        }
        while(true){
            int nodeCountAtLevel = q.size();
            if(nodeCountAtLevel==0) return noOfLevels;
            while(nodeCountAtLevel>0){
                TreeNode current = q.poll();
                if(current.left !=null){
                    q.offer(current.left);
                }
                if(current.right !=null){
                    q.offer(current.right);
                }
                nodeCountAtLevel--;
            }
            noOfLevels++;
        }
    }
}
