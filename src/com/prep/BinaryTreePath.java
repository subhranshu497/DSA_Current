package com.prep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePath {
    private static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        result = binaryTreePaths(root);
    }

    private static List<String> binaryTreePaths(TreeNode root) {
       LinkedList<String> paths = new LinkedList<>();
       constructPaths(root, "", paths);
       return paths;
    }

    private static void constructPaths(TreeNode root, String path, LinkedList<String> paths) {
        if(root != null){
            path +=Integer.toString(root.val);
            if((root.left == null)&&(root.right==null)) paths.add(path);
            else{
                path +="->";
                constructPaths(root.left,path,paths);
                constructPaths(root.right,path,paths);
            }
        }
    }


}
