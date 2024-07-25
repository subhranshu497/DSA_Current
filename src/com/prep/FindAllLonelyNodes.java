package com.prep;

import java.util.ArrayList;
import java.util.List;

public class FindAllLonelyNodes {
    private static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode3 root = new TreeNode3(7);
        root.left = new TreeNode3(1);
        root.right = new TreeNode3(4);
        root.left.left = new TreeNode3(6);
        root.right.left = new TreeNode3(5);
        root.right.right = new TreeNode3(3);
        root.right.right.right = new TreeNode3(2);
        List<Integer> result = getLonelyNodes(root);
        System.out.println(result);
    }

    private static List<Integer> getLonelyNodes(TreeNode3 root) {
        processNode(root,false);
        return result;
    }

    private static void processNode(TreeNode3 root, boolean isLonely) {
        if(root == null) return;
        if(isLonely)result.add(root.val);
        processNode(root.left, root.right==null);
        processNode(root.right, root.left==null);
    }

}
class TreeNode3{
    int val;
    TreeNode3 left;
    TreeNode3 right;
    public TreeNode3(){}
    public TreeNode3(int val){
        this.val = val;
    }
    public TreeNode3(int val, TreeNode3 left, TreeNode3 right){
        this.val = val;
        this.right = right;
        this.left = left;
    }
}
