package com.prep;

import com.sun.source.tree.Tree;

public class DeleteNodeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        //root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(3);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(7);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(7);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
        int val = 8;
        TreeNode result = deleteNode(root, val);
        // print result
        inorderTraversalBST(result);
    }

    private static void inorderTraversalBST(TreeNode result) {
        if(result == null) return;
        inorderTraversalBST(result.left);
        System.out.print(result.val+" ");
        inorderTraversalBST(result.right);
    }

    private static TreeNode deleteNode(TreeNode root, int val) {
        //when val is not in the tree
        if(root == null) return root;
        if(val < root.val)root.left = deleteNode(root.left, val);
        else if(val> root.val)root.right = deleteNode(root.right, val);
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private static int minValue(TreeNode root) {
        int min = root.val;
        while(root.left !=null){
            min = root.left.val;
            root = root.left;
        }
        return min;
    }
}
