package com.prep.dfs;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        System.out.println(validateBST(root));
    }

    private static boolean validateBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        bstHelper(root, result);
        for(int i=1;i<result.size();i++){
            if(result.get(i)<result.get(i-1))return false;
        }
        return true;
    }

    private static void bstHelper(TreeNode root, List<Integer> result) {
        //base condition
        if(root ==null) return;
        bstHelper(root.left, result);
        result.add(root.val);
        bstHelper(root.right, result);
    }
}
