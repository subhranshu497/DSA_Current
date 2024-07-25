package com.prep.dayCount.practice.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 06/25/2024 = day 1
 * Easy, leetcode # 94
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = inorderTraversal(root);
        System.out.println(result);
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsInorder(root, result);
        return result;
    }

    private static void dfsInorder(TreeNode root, List<Integer> result) {
        if(root==null)return;
        dfsInorder(root.left, result);
        result.add(root.val);
        dfsInorder(root.right, result);
    }
}

class TreeNode{
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
