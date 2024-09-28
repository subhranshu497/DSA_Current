package com.prep;

import java.util.ArrayList;
import java.util.List;

public class LinkedListInBinaryTree {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);

        boolean flag = isSubPath(head, root);
        System.out.println(flag);
    }

    private static boolean isSubPath(ListNode head, TreeNode root) {
        List<Integer> treeResult = new ArrayList<>();
        //traverse the tree preOrder
        preOrderTraversal(root,treeResult);
        System.out.println(treeResult);
        return false;
    }

    private static void preOrderTraversal(TreeNode root, List<Integer> treeResult) {
        if(root==null)return;
        preOrderTraversal(root.left, treeResult);
        treeResult.add(root.val);
        preOrderTraversal(root.right, treeResult);
    }
}
