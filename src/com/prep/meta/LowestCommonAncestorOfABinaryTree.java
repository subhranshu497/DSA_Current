package com.prep.meta;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        Node p =new Node(5);
        Node q =new Node(1);
        Node result = lowestCommonAncestorIIII(p,q);

    }

    private static Node lowestCommonAncestorIIII(Node p, Node q) {
        Set<Node> hs = new HashSet<>();
        while(p !=null){
            hs.add(p);
            p = p.parent;
        }
        while(q !=null){
            if(!hs.contains(q)) q =q.parent;
            else{
                return q;
            }
        }
        return null;
    }

    private static TreeNode lowestCommonAncestorIII(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root==null || root==p || root==q) return root;

        TreeNode left = lowestCommonAncestorIII(root.left,p,q);
        TreeNode right = lowestCommonAncestorIII(root.right, p,q);
        if(left ==null) return right;
        else if(right ==null) return left;
        else return root;
    }
}
class Node{
    public int val;
    public Node left;
    public Node right;
    public Node parent;
    public Node(int val){
        this.val = val;
    }
}
