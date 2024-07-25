package com.prep.dfs;

public class FlattenABinaryTreeToLinkedList {
    private static TreeNode prev;
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        flattenBinaryTreeToLinkedList(root);
    }

    private static void flattenBinaryTreeToLinkedList(TreeNode root) {
        prev = null;
        preOrderTraversalHelper(root);
    }

    private static void preOrderTraversalHelper(TreeNode node) {
        //base condition
        if(node == null) return;
        if(prev !=null){
            prev.left = null;
            prev.right = node;
        }
        TreeNode r = node.right;
        prev = node;
        preOrderTraversalHelper(node.left);
        preOrderTraversalHelper(r);
    }
}
