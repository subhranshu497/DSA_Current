package com.prep;

import java.util.Stack;

public class DistributeCoinsBinaryTree {
    public static int steps;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        steps = distributeCoins(root);
        System.out.println(steps);
    }

    private static int distributeCoins(TreeNode root) {
       steps = 0;
       bfsCoins(root);
       return steps;
    }

    private static int bfsCoins(TreeNode root) {
        if(root==null) return 0;
        int leftCoins = bfsCoins(root.left);
        int rightCoins = bfsCoins(root.right);
        steps +=Math.abs(leftCoins)+Math.abs(rightCoins);
        return leftCoins+rightCoins+ (root.val-1);
    }
}
