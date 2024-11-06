package com.prep;

public class FlipEquivalentBinaryTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode();
        TreeNode root2 = new TreeNode(1);
        System.out.println(flipEquiv(root1,root2));
    }

    private static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //base case
        if(root1== null && root2==null) return true;
        if(root1== null || root2 == null) return false;
        if(root1.val == root2.val){
            boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            return flip || noFlip;
        }
        return false;
    }

    static class TreeNode{
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
}
