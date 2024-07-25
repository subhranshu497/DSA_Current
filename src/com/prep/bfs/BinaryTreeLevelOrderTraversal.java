package com.prep.bfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    private static List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(12);
        results = levelOrderTraversalOne(root);
        for (List<Integer> list : results) {
            System.out.print(list + ", ");
        }
    }

    private static List<List<Integer>> levelOrderTraversalOne(TreeNode root) {
        if(root==null) return results;
        levelOrderRecursionHelper(0, root);
        return results;
    }

    private static void levelOrderRecursionHelper(int level, TreeNode node) {
        if(level==results.size()) results.add(new ArrayList<>());
        results.get(level).add(node.val);
        if(node.left !=null) levelOrderRecursionHelper(level+1, node.left);
        if(node.right !=null) levelOrderRecursionHelper(level+1, node.right);
    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

