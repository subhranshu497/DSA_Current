package com.prep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescription {
    public static void main(String[] args) {
        int[][] description = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        TreeNode root = createbinaryTree(description);
    }

    private static TreeNode createbinaryTree(int[][] description) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> childrenSet = new HashSet<>();
        for(int[] arr:description){
            int parentValue = arr[0];
            int childValue = arr[1];
            int isLeft = arr[2];
            childrenSet.add(childValue);
            TreeNode root = map.getOrDefault(parentValue, new TreeNode(parentValue));
            if(isLeft==1){
                root.left = map.getOrDefault(childValue, new TreeNode(childValue));
                map.put(childValue, root.left);
            }
            else{
                root.right = map.getOrDefault(childValue, new TreeNode(childValue));
                map.put(childValue, root.right);
            }
            map.put(parentValue,root);
        }
        int node =-1;
        for(int [] arr:description){
            if(!childrenSet.contains(arr[0])){
                node = arr[1];
                break;
            }
        }
        return map.getOrDefault(node,null);
    }
}
