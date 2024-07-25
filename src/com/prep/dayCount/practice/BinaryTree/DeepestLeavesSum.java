package com.prep.dayCount.practice.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeepestLeavesSum {
    private static int deepestSum=0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right  = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        root.left.left.left = new TreeNode(7);
        deepestSum = deepestLeavesSum(root);
        System.out.println(deepestSum);
    }

    private static int deepestLeavesSum(TreeNode root) {
        int noOfLevels =-1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int noOfNodesInQ =q.size();
        while (!q.isEmpty()){
            while(noOfNodesInQ !=0){
                TreeNode current = q.poll();
                noOfNodesInQ--;
                if(current.left !=null){
                    q.offer(current.left);
                }
                if(current.right !=null){
                    q.offer(current.right);
                }
            }
            noOfLevels++;
            noOfNodesInQ =q.size();
        }
       // System.out.println(noOfLevels);
        //appl dfs to reach till the deepest level and sum
        int sum =0;
        Queue<TreeNode> q2 = new LinkedList<>();
        int count =0;
        q2.offer(root);
        int nodeCountInQ2 = q2.size();
        while(count<noOfLevels){
            while(nodeCountInQ2 !=0){
                TreeNode current = q2.poll();
                nodeCountInQ2--;
                    if(current.left !=null){
                        q2.offer(current.left);
                    }
                    if(current.right !=null){
                        q2.offer(current.right);
                    }
            }
            count++;
            nodeCountInQ2 =q2.size();
        }
       // System.out.println(q2.size());
        while(!q2.isEmpty()){
            TreeNode curr =q2.poll();
            System.out.println(curr.val);
            sum += curr.val;
        }
        return sum;
    }
}
