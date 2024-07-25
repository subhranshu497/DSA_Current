package com.prep;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class RangeSumOfBST {
    public static int sum =0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        int low = 7;
        int high = 15;
        sum = rangeSumBSTRecursion(root, low, high);
        System.out.println(sum);
    }

    private static int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        if(root != null)stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            if(top !=null){
                if(top.val<=high && top.val >=low) sum +=top.val;
                if(low<top.val)stack.push(top.left);
                if(top.val < high)stack.push(top.right);
            }
        }
        return sum;
    }
    private static int rangeSumBSTRecursion(TreeNode root, int low, int high) {
        if(root == null) return sum;
        bfsBST(root, low,high);
        return sum;
    }

    private static void bfsBST(TreeNode root, int low, int high) {
        if(root == null)return;
        else{
            if(low <=root.val && root.val<=high)sum +=root.val;
            if(low< root.val)bfsBST(root.left,low,high);
            if(root.val<=high)bfsBST(root.right,low,high);
        }
    }
}
