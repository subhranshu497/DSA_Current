package com.prep;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        TreeNode result = balanceBST(root);
    }

    private static TreeNode balanceBST(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        inorderTraversalBSTOne(root, nodeList);
        return formBSTfromList(nodeList,0,nodeList.size()-1);
    }

    private static TreeNode formBSTfromList(List<Integer> nodeList, int low, int high) {
        // base condition
        if(low>high)return null;
        int mid = low+(high-low)/2;
        TreeNode leftSub=formBSTfromList(nodeList, low,mid-1);
        TreeNode rightSub=formBSTfromList(nodeList, mid+1,high);
        TreeNode root = new TreeNode(nodeList.get(mid),leftSub,rightSub);
        return root;
    }

    private static void inorderTraversalBSTOne(TreeNode root, List<Integer> nodeList) {
        if(root==null) return;
        inorderTraversalBSTOne(root.left,nodeList);
        nodeList.add(root.val);
        inorderTraversalBSTOne(root.right,nodeList);
    }
}
