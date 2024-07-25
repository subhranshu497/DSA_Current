package com.prep;

public class SplitBST {
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(4);
        root.left = new TreeNode1(2);
        root.left.left = new TreeNode1(1);
        root.left.right = new TreeNode1(3);
        root.right = new TreeNode1(6);
        root.right.left = new TreeNode1(5);
        root.right.right = new TreeNode1(7);
        int v = 2;
        TreeNode1[] spltited = splitTree(root, v);
    }

    private static TreeNode1[] splitTree(TreeNode1 root, int target) {
        if(root==null) return new TreeNode1[]{null, null};
        TreeNode1 [] splited;
        if(target >= root.val){
            splited =splitTree(root.right, target);
            root.right = splited[1];
            splited[1] = root;
        }
        else{
            splited=splitTree(root.left, target);
            root.left = splited[0];
            splited[0] =root;
        }
        return splited;
    }

}
class TreeNode1{
    int val;
    TreeNode1 left;
    TreeNode1 right;
    public TreeNode1(){}
    public TreeNode1(int val){
        this.val = val;
    }
    public TreeNode1(int val, TreeNode1 left, TreeNode1 right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
