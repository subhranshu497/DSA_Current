package com.prep.dayCount.practice.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 06/25/2024 = day 1
 * Easy, leetcode # 100
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(1);

        boolean flag = isSameTreeCheck(p,q);
        System.out.println(flag);
    }

    private static boolean isSameTreeCheck(TreeNode p, TreeNode q) {

        //base condition
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val != q.val) return false;
        return isSameTreeCheck(p.left,q.left)&&isSameTreeCheck(p.right, q.right);
    }
}
