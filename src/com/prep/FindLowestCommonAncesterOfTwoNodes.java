package com.prep;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FindLowestCommonAncesterOfTwoNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        int p = 5;
        int q = 0;
        int lca = findDistance(root, p,q);
        System.out.println("LCA   "+lca);
    }

    private static int findDistance(TreeNode root, int p, int q) {
        TreeNode lcaNode = dfsLCA(root,p,q);
        int d1 = distanceFromLCA(lcaNode,p,0);
        int d2 = distanceFromLCA(lcaNode,q,0);
        return d1+d2;
    }

    private static int distanceFromLCA(TreeNode root, int nodeVal, int dist) {
        if(root==null) return 0;
        if(root.val==nodeVal)return dist;
        int depth=distanceFromLCA(root.left, nodeVal,dist+1);
        if(depth !=0) return depth;
        else{
            depth= distanceFromLCA(root.right, nodeVal,dist+1);
            return depth;
        }
    }

    private static TreeNode dfsLCA(TreeNode root, int p, int q) {
        if(root==null) return null;
        if(root.val ==p || root.val ==q) return root;
        TreeNode left = dfsLCA(root.left, p,q);
        TreeNode right = dfsLCA(root.right,p,q);
        if(left==null)return  right;
        if(right==null)return  left;
        return root;
    }
}
