package com.prep.bfs;

import java.util.*;

public class BTreeZigzagLevelOrderTraversalQueue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> results = levelOrderTraversalZigzag(root);
        for(List<Integer> list : results){
            System.out.print(list+", ");
        }
    }

    private static List<List<Integer>> levelOrderTraversalZigzag(TreeNode root) {
        List<List<Integer>> resultsList = new ArrayList<>();
        if(root==null) return resultsList;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean zigzag = true;
        while(!q.isEmpty()){
            int qLen = q.size();
            List<Integer> tempList = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<qLen;i++){
                TreeNode node = q.remove();
                if(zigzag){
                    tempList.add(node.val);
                }
                else{
                    stack.push(node.val);
                }
                if(node.left !=null) q.add(node.left);
                if(node.right !=null) q.add(node.right);
            }
            zigzag = !zigzag;
            while(!stack.isEmpty()){
                tempList.add(stack.pop());
            }
            resultsList.add(tempList);
        }
        return resultsList;
    }
}
