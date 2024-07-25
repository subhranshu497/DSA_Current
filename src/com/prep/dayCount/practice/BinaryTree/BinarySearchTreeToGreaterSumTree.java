package com.prep.dayCount.practice.BinaryTree;
/**
 * 06/25/2024 = day 1
 * medium, leetcode # 1038
 */
public class BinarySearchTreeToGreaterSumTree {
    public static int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        TreeNode result = bstToGstOne(root);

    }

    private static TreeNode bstToGstOne(TreeNode root) {
        bfsbstToGstOne(root);
        return root;
    }

    private static void bfsbstToGstOne(TreeNode root) {
        if(root == null) return;
        bfsbstToGstOne(root.right);
        root.val +=sum;
        sum = root.val;
        bfsbstToGstOne(root.left);
    }
}
