package com.prep;

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int val = 2;
        TreeNode resultNode = searchBST(root, val);
    }

    private static TreeNode searchBST(TreeNode root, int val) {
        if(root == null || val == root.val) return root;

        return val<root.val?searchBST(root.left, val):searchBST(root.right,val);
    }
    private static TreeNode searchBSTIteration(TreeNode root, int val) {
        if(root == null) return root;
        while(root !=null){
            if(val<root.val) root = root.left;
            else if(val>root.val)root = root.right;
            else return root;
        }
        return null;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val=val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left =left;
        this.right = right;
    }
}
