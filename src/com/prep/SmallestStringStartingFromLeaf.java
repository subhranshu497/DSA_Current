package com.prep;

import java.util.List;

public class SmallestStringStartingFromLeaf {
    public static void main(String[] args) {
        TreeNode3 root = new TreeNode3(25);
        root.left = new TreeNode3(1);
        root.right = new TreeNode3(3);
        root.left.left = new TreeNode3(1);
        root.left.right = new TreeNode3(3);
        root.right.left = new TreeNode3(0);
        root.right.right = new TreeNode3(2);
        String result = smallestFromLeaf(root);
        System.out.println(result);
    }
    private static String smallestFromLeaf(TreeNode3 root) {
        String smallestStr="";
        dfsSmallest(root, "",smallestStr);
        return smallestStr;
    }

    private static String dfsSmallest(TreeNode3 root, String currentStr, String smallestStr) {
        if(root==null) return null;
        currentStr = (char)(root.val+'a')+currentStr;
        if(root.left==null && root.right==null){
            if(smallestStr.isEmpty() || smallestStr.compareTo(currentStr)>0){
                smallestStr = currentStr;
                return smallestStr;
            }
        }
        if(root.left !=null) dfsSmallest(root.left, currentStr, smallestStr);
        if(root.right !=null) dfsSmallest(root.right, currentStr, smallestStr);
        return smallestStr;
    }
}
