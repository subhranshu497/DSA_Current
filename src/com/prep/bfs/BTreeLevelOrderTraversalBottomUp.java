package com.prep.bfs;

import java.util.*;

public class BTreeLevelOrderTraversalBottomUp {
    private static List<List<Integer>> results = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(12);
        results = levelOrderTraversalTwoBottomsUp(root);
        for (List<Integer> list : results) {
            System.out.print(list + ", ");
        }
    }

    private static List<List<Integer>> levelOrderTraversalTwoBottomsUp(TreeNode root) {
        if(root==null) return results;
        Queue<TreeNode> q =new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        q.add(root);
        int level =0;
        while (!q.isEmpty()){
            int n = q.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = q.remove();
                tempList.add(node.val);
                if(node.left !=null) q.add(node.left);
                if(node.right !=null) q.add(node.right);
            }
            stack.push(tempList);
            //results.add(tempList);
        }
        while (!stack.isEmpty()){
            results.add(stack.pop());
        }
        return results;
    }
}
