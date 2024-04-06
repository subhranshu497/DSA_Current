package com.prep;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(7);
        System.out.println(findBottomLeftValue(root));
    }

    private static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left !=null)q.offer(node.left);
            if(node.right !=null)q.offer(node.right);
        }
        return 0;
    }
}
