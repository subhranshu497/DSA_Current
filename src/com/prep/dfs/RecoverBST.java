package com.prep.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RecoverBST {
    private static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        recoverTree(root);
    }

    private static void recoverTree(TreeNode root) {
        result = inOrderTraversalToRecoverBST(root);
        Integer first = null;
        Integer second = null;
        int prev = result.get(0);
        for(int i=1;i<result.size();i++){
            if(prev >result.get(i) && first ==null) first = prev;
            if(prev > result.get(i) && first != null) second = result.get(i);
            prev = result.get(i);
        }
        searchAndUpdate(root, first, second);
    }

    private static void searchAndUpdate(TreeNode root, Integer first, Integer second) {
        if(root == null) return;
        searchAndUpdate(root.left,first, second);
        if(root.val == first) root.val = second;
        else if(root.val == second) root.val = first;
        searchAndUpdate(root.right,first, second);
    }

    private static List<Integer> inOrderTraversalToRecoverBST(TreeNode root) {
        inOrderTraversalToRecoverBSTHelper(root);
        return result;
    }

    private static void inOrderTraversalToRecoverBSTHelper(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current !=null || !stack.isEmpty()){
            while(current !=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
    }
}
