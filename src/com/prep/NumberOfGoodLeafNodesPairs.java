package com.prep;

import java.util.ArrayList;
import java.util.List;

public class NumberOfGoodLeafNodesPairs {
    private static int count =0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int dist = 3;
        count = distanceGoodPairLeaf(root, dist);
        System.out.println(count);
    }

    private static int distanceGoodPairLeaf(TreeNode root, int dist) {
        distanceDFS(root,dist);
        return count;
    }

    private static List<Integer> distanceDFS(TreeNode root, int dist) {
        if(root==null) return new ArrayList<>();
        if(root.left==null && root.right==null) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            return res;
        }
        List<Integer> leftList =distanceDFS(root.left, dist);
        List<Integer> rightList =distanceDFS(root.right, dist);
        System.out.println("Left List "+leftList+" Right List "+rightList);
        List<Integer> list = new ArrayList<>();
        for(int i:leftList){
            for(int j:rightList){
                if(i+j <=dist)count++;
            }
        }
        for(int val:leftList)list.add(val+1);
        for(int val:rightList)list.add(val+1);
        System.out.println(list);
        return list;
    }
}
