package com.prep;

import java.util.*;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(9);
        root.right.right.left = new TreeNode(10);
        int count = minimumOperations(root);
        System.out.println(count);
    }

    private static int minimumOperations(TreeNode root) {
        int count =0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while(size-- >0){
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right !=null){
                    q.add(curr.right);
                }
            }
            List<Integer> sortedLevel = new ArrayList<>(level);
            Collections.sort(sortedLevel);
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0;i<level.size();i++){
                map.put(level.get(i),i);
            }
            for(int i=0;i<level.size();i++){
                while(level.get(i) != sortedLevel.get(i)){
                    count++;
                    int cur = map.get(sortedLevel.get(i));
                    map.put(level.get(i),cur);
                    Collections.swap(level,i,cur);
                }
            }
        }
        return count;
    }
}
