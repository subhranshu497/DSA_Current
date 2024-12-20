package com.prep;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {
    public static void main(String[] args) {
        TreeNode4 root = new TreeNode4(2);
        root.left = new TreeNode4(3);
        root.right = new TreeNode4(5);
        root.left.left= new TreeNode4(8);
        root.left.right = new TreeNode4(13);
        root.right.left =new TreeNode4(21);
        root.right.right = new TreeNode4(34);

        TreeNode4 result = reverseOddLevels(root);
    }

    private static TreeNode4 reverseOddLevels(TreeNode4 root) {
        reverseOddLevelsDFS(root.left, root.right,0);
        return root;
    }

    private static void reverseOddLevelsDFS(TreeNode4 leftNode, TreeNode4 rightNode, int level) {
        //base condition
        if(leftNode == null || rightNode == null)return;
        if(level % 2 == 0){
            int temp = leftNode.val;;
            leftNode.val = rightNode.val;
            rightNode.val = temp;
        }
        reverseOddLevelsDFS(leftNode.left,rightNode.right, level+1);
        reverseOddLevelsDFS(leftNode.right,rightNode.left, level+1);
    }
}
class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;
    public TreeNode4(){}
    public TreeNode4(int val){
        this.val = val;
    }
    public TreeNode4(int val, TreeNode4 left, TreeNode4 right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
