package com.prep;

import java.util.Stack;

public class CountNodesEqualToSumOfDescendants {
    static int count;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        System.out.println(equalToDescendants(root));
    }

    private static int equalToDescendants(TreeNode root) {
        countNodes(root);
        return count;
    }

    private static int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        if(root.val == left+right)count++;

        return left+right+root.val;
    }
}
