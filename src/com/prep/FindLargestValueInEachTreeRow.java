package com.prep;

import java.util.*;

public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        int [] res = largestValues(root);

        for(int num:res)
            System.out.print(num+", ");
    }

    private static int[] largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        int level =0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> listTemp = new ArrayList<>();
            while (size-- >0){
                TreeNode curr = q.poll();
                listTemp.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            Collections.sort(listTemp);
            //add element to res list
            l.add(listTemp.get(listTemp.size()-1));
        }
        int [] res = new int[l.size()];
        for(int i=0;i<res.length;i++){
            res[i] = l.get(i);
        }
        return res;
    }
}
