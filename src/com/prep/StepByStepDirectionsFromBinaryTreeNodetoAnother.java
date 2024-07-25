package com.prep;

public class StepByStepDirectionsFromBinaryTreeNodetoAnother {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        int start =3;
        int dest =6;
        String result = getDirections(root,start, dest);
        System.out.println(result);
    }

    private static String getDirections(TreeNode root, int start, int dest) {
        StringBuilder sourcePath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();
        //caculate LCA
        TreeNode lca = calculateLCA(root, start, dest);
        //find path
        findPath(lca, start, sourcePath);
        findPath(lca, dest, destPath);
        for(int i=0;i<sourcePath.length();i++){
            sourcePath.setCharAt(i,'U');
        }
        return sourcePath+destPath.reverse().toString();
    }

    private static boolean findPath(TreeNode lca, int target, StringBuilder path) {
        if(lca==null) return false;
        if(lca.val==target) return true;
        if(findPath(lca.left,target,path)){
            path.append("L");
            return true;
        }
        if(findPath(lca.right,target,path)){
            path.append("R");
            return true;
        }
        return false;
    }
    private static TreeNode calculateLCA(TreeNode root, int start, int dest) {
        if(root==null || root.val==start || root.val==dest) return root;
        TreeNode left = calculateLCA(root.left,start,dest);
        TreeNode right = calculateLCA(root.right,start,dest);
        if(left ==null) return right;
        if(right==null) return left;
        return root;
    }
}
