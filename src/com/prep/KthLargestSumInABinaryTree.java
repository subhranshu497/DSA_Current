package com.prep;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestSumInABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
//        root.left.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        int k = 4;
        long result = kthLargestLevelSum(root, k);
        System.out.println(result);
    }

    private static long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        q.add(root);
        pq.add((long)root.val);
        while(!q.isEmpty()){
            int size =q.size();
            long tempSum =0;
            while(size != 0){
                TreeNode curr = q.poll();
                size--;
                if(curr.left !=null){
                    q.add(curr.left);
                    tempSum +=curr.left.val;
                }
                if(curr.right !=null){
                    q.add(curr.right);
                    tempSum +=curr.right.val;
                }
            }
            pq.add(tempSum);
        }
        long result =-1;
        System.out.println(pq.size());
        if(k >=pq.size()) return -1;
        //iterate the priority queue
        while(k !=0){
            result = pq.poll();
            k--;
        }
        return result;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
