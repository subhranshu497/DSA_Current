package com.prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left =new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] to_delete = {3,5};
        List<TreeNode> forest = deleteNodes(root, to_delete);
    }

    private static List<TreeNode> deleteNodes(TreeNode root, int[] toDelete) {
        Set<Integer> set = new HashSet<>();
        List<TreeNode> result = new ArrayList<>();
        //put the arr into a set for better traversal
        for(int i:toDelete){
            set.add(i);
        }
        deleteNodeHelper(root, set, result);
        postOrderTraversal(root);
        if(!set.contains(root.val))result.add(root);
        return result;
    }

    private static void postOrderTraversal(TreeNode node) {
        if (node==null)return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val+" ");
    }

    private static TreeNode deleteNodeHelper(TreeNode root, Set<Integer> set, List<TreeNode> result) {
        if(root==null) return null;
        root.left= deleteNodeHelper(root.left, set,result);
        root.right = deleteNodeHelper(root.right, set,result);
        if(set.contains(root.val)){
            if(root.left !=null){
                result.add(root.left);
            }
            if(root.right !=null){
                result.add(root.right);
            }
            root =null;
             return root;
        }
        else{
           return root;
        }
    }
}
