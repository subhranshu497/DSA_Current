package com.prep;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTreeII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right.right = new TreeNode(7);

        TreeNode result = replaceValueInTree(root);
    }

    private static TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int levelSum = root.val;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            int nextLevelSum =0;
            while(n !=0){
                TreeNode curr = q.poll();
                n--;
                curr.val =levelSum- curr.val;
                int siblingSum = (curr.left !=null ?curr.left.val:0);
                siblingSum +=(curr.right !=null ? curr.right.val:0);
                if(curr.left !=null){
                    nextLevelSum += curr.left.val;
                    curr.left.val = siblingSum;
                    q.add(curr.left);
                }
                if(curr.right !=null){
                    nextLevelSum += curr.right.val;
                    curr.right.val = siblingSum;
                    q.add(curr.right);
                }
            }
            levelSum = nextLevelSum;
        }
        return root;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
