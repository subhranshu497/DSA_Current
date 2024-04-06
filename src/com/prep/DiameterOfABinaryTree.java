package com.prep;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Leetcode # 543
public class DiameterOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.left = new TreeNode(0);
        root.right.right.left.right = new TreeNode(9);
        System.out.println(diameterOfBinaryTree(root));
    }

    private static int diameterOfBinaryTree(TreeNode node) {
        int diameter = 0;
        Stack<TreeNode> stack= new Stack<>();
        Map<TreeNode,Integer>nodeDepthMap = new HashMap<>();
        if(node !=null) stack.push(node);
        while(!stack.isEmpty()){
            TreeNode root = stack.peek();
            //do post order traversal
            if(root.left !=null && !nodeDepthMap.containsKey(root.left))stack.push(root.left);
            else if(root.right !=null && !nodeDepthMap.containsKey(root.right))stack.push(root.right);
            else{
                stack.pop();
                int leftHeight = nodeDepthMap.getOrDefault(root.left,0);
                int rightHeight = nodeDepthMap.getOrDefault(root.right,0);
                nodeDepthMap.put(root, 1+Math.max(leftHeight,rightHeight));
                diameter = Math.max(diameter, leftHeight+rightHeight);
            }
        }
        return diameter;
    }
}
