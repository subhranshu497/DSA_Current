package com.prep;

public class DeleteLeavesWithAGivenValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        int target = 2;
        TreeNode result = removeLeafNodes(root, target);
    }

    private static TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) return null;
        if(root.left !=null){
            removeLeafNodes(root.left, target);
        }
        if(root.right !=null){
            removeLeafNodes(root.right, target);
        }
        if(root.left == null && root.right==null && root.val == target)root = null;

        return root;
    }
}
