package com.prep;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(evenOddTreeChecker(root));
    }

    private static boolean evenOddTreeChecker(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        queue.add(current);

        boolean even = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = Integer.MAX_VALUE;
            if (even) {
                prev = Integer.MIN_VALUE;
            }
            while (size > 0) {
                current = queue.poll();
                if ((even && (current.val % 2 == 0 || current.val <= prev)) ||
                        (!even && (current.val % 2 == 1 || current.val >= prev))) {
                    return false;
                }
                prev = current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                size--;
            }
            even = !even;
        }
        return true;
    }
}
