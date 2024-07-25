package com.prep.dayCount.practice.BinaryTree;


/**
 * 06/25/2024 = day 1
 * Easy, leetcode # 938
 */
public class RangeSumOfBST {
    public static int sum =0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        int low = 7;
        int high = 15;
        sum =rangeSumBSTOne(root,  low, high);
        System.out.println(sum);
    }

    private static int rangeSumBSTOne(TreeNode root, int low, int high) {
         dfsInorderRangeSumBSTOne(root, low, high);
        return sum;
    }

    private static void dfsInorderRangeSumBSTOne(TreeNode root, int low, int high) {
        if(root==null)return;
        dfsInorderRangeSumBSTOne(root.left, low, high);
        if(root.val >=low && root.val <=high) sum += root.val;
        dfsInorderRangeSumBSTOne(root.right, low, high);
    }

}
