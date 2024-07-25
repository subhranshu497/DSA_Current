package com.prep;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EvaluateBooleanBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(evaluateTreeRecursion(root));
    }

    private static boolean evaluateTreeRecursion(TreeNode root) {
        if(root.left == null && root.right ==null) return root.val !=0;
        boolean evalLeftSubTree = evaluateTree(root.left);
        boolean evalRightSubTree = evaluateTree(root.right);
        boolean evalRoot;
        if(root.val==2) evalRoot = evalLeftSubTree || evalRightSubTree;
        else evalRoot = evalLeftSubTree && evalRightSubTree;

        return evalRoot;
    }
    private static boolean evaluateTree(TreeNode root) {
        Map<TreeNode, Boolean> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.peek();
            if(top.left == null && top.right == null){
                stack.pop();
                map.put(top, top.val == 1);
                continue;
            }
            if(map.containsKey(top.left) && map.containsKey(top.right)){
                stack.pop();
                if(top.val ==2){
                    map.put(top, map.get(top.left)||map.get(top.right));
                }
                else{
                    map.put(top, map.get(top.left) && map.get(top.right));
                }
            }
            else{
                stack.push(top.right);
                stack.push(top.left);
            }
        }
        return map.get(root);
    }


}
