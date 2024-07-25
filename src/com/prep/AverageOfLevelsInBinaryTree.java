package com.prep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(8);
//        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
       List<Double> avg = averageOfLevels(root);
       // System.out.println(avg);
        //levelOrderTraversal(root);
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(q.peek() !=null){
            double sum=0;
            int nodesCount =0;
            while(q.peek() !=null){
                TreeNode curr = q.poll();
                sum +=curr.val;
                nodesCount++;
                if(curr.left !=null) q.add(curr.left);
                if(curr.right !=null) q.add(curr.right);
            }
            q.offer(q.poll());
            result.add(sum/nodesCount);
        }
        System.out.println(result);
        return result;
    }
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        int level =0;
        List<Integer> result = new ArrayList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            if(current.left !=null){
                q.offer(current.left);
            }
            if(current.right !=null){
                q.offer(current.right);
            }
            result.add(current.val);
        }
        System.out.println(result);
    }
}
