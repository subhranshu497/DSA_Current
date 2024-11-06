package com.prep;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {
    private static int [] level = new int[100001];
    private static int [] height = new int[100001];
    private static int [] maxheight = new int[100001];
    private static int [] secondMaxHeight = new int[100001];
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        int[] queries = {4};
        int [] result = treeQueries(root,queries);
    }

    public static int[] treeQueries(TreeNode root, int[] queries) {
        //at the start level is 0 so pass 0 along with root to compute the height and other values
        height[root.val]= treeHeight(root, 0);
        int [] result = new int[queries.length];
        //start iterating the queries
        int i=0;
        for(int q:queries){
            int l = level[q];
            //l+h-1
            int tempRes = l+(maxheight[l]==height[q]?secondMaxHeight[l] :maxheight[l])-1;
            result[i] = tempRes;
            i++;
        }
        return result;
    }
    private static int treeHeight(TreeNode root, int l) {
        if(root ==null) return 0;
        level[root.val] = l;
        height[root.val] = Math.max(treeHeight(root.left,l+1), treeHeight(root.right, l+1))+1;
        if(maxheight[l] < height[root.val]){
            secondMaxHeight[l] = maxheight[l];
            maxheight[l] = height[root.val];
        }
        else if(secondMaxHeight[l] < height[root.val]){
            secondMaxHeight[l] = height[root.val];
        }
        return height[root.val];
    }
}
