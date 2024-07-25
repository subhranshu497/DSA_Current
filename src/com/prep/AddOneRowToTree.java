package com.prep;

public class AddOneRowToTree {
    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(4);
        root.left = new TreeNode2(2);
        root.right = new TreeNode2(6);
        root.left.left= new TreeNode2(3);
        root.left.right = new TreeNode2(1);
        root.right.left = new TreeNode2(5);
        int value = 1;
        int depth = 2;
        TreeNode2 resultTree = addOneRow(root, value, depth);
    }

    private static TreeNode2 addOneRow(TreeNode2 root, int value, int depth) {
       if(depth==1){
           TreeNode2 node = new TreeNode2(value);
           node.left = root;
           return node;
       }
       processAndInsert(root, value,depth, 1);
       return root;
    }
    private static void processAndInsert(TreeNode2 node, int value, int depth, int level){
        if(node== null)return;
        if(level==depth-1){
            TreeNode2 temp = node.left;
            node.left = new TreeNode2(value);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode2(value);
            node.right.right = temp;
        }
        else{
            processAndInsert(node.left, value, depth, level+1);
            processAndInsert(node.right, value, depth, level+1);
        }
    }
}

class TreeNode2{
    int val;
    TreeNode2 left;
    TreeNode2 right;

    public TreeNode2(){}
    public TreeNode2(int val) {
        this.val = val;
    }
    public TreeNode2(int val, TreeNode2 left, TreeNode2 right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
