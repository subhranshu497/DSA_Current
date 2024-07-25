package com.prep.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> inorder = inOrderByStack(root);
        System.out.println(inorder);
    }

    private static List<Integer> inOrderByStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr !=null || !stack.isEmpty()){
            while(curr !=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
    private static List<Integer> inOrderTraversalRecursion(TreeNode root) {
        recHelper(root);
        return result;
    }
    private static void recHelper(TreeNode root){
        if(root==null)return;
        recHelper(root.left);
        result.add(root.val);
        recHelper(root.right);
    }
}
class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode right, TreeNode left){
        this.val = val;
        this.right = right;
        this.left= left;
    }
}
