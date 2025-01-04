package com.prep;

public class LowestCommonAncestorOfBinaryTreeII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode result = lowestCommonAncestorII(root, p,q);
    }

    private static TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        //base condition
        if(root == null)
            return null;
        if(p == root || q == root)
            return root;
        TreeNode lNode = lowestCommonAncestorII(root.left, p, q);
        TreeNode rNode = lowestCommonAncestorII(root.right, p, q);
        if(lNode != null && rNode !=null)
            return root;
        return null;
    }


    //LCA I

//    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        //base condition
//        if(root == null)
//            return null;
//        if(root == p || root == q) return root;
//        TreeNode lNode = lowestCommonAncestor(root.left, p,q);
//        TreeNode rNode = lowestCommonAncestor(root.right,p,q);
//        if(lNode != null && rNode != null)
//            return root;
//        if(lNode != null) return lNode;
//        return rNode;
//    }
}
