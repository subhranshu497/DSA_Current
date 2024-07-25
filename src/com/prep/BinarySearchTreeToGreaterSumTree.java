package com.prep;

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
        TreeNode result = bstToGst(root);
    }

    private static TreeNode bstToGst(TreeNode root) {
        dfsSum(root);
        return root;
    }

    private static void dfsSum(TreeNode root) {
        if(root == null) return;
        dfsSum(root.right);
        root.val +=sum;
        sum =root.val;
        dfsSum(root.left);
        return;
    }
}
