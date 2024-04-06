package com.prep.dstc.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private static List<Integer> treeNodeList = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(40);
        root.left.left = new TreeNode(10);
        root.right.left = new TreeNode(20);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(30);
        //insertToMaxHeap(root, 60);
        levelOrderTraversal(root);
        int[] arr = new int[treeNodeList.size()+1];
        for (int i=0;i<treeNodeList.size();i++) {
            arr[i] = treeNodeList.get(i);
            System.out.print(arr[i]+", ");
        }
        buildHeap(arr);
    }

    public static void insertToMaxHeap(TreeNode root, int value){
        //first find the level order
        levelOrderTraversal(root);
        System.out.println(treeNodeList);
        int[] arr = new int[treeNodeList.size()+1];
        int n = treeNodeList.size();
        n = n+1;
        for(int i=1;i<n;i++) arr[i] =treeNodeList.get(i-1);
        for(int i=1;i<n;i++) System.out.print(arr[i]+", ");
        System.out.println();
        arr[n-1] = value;
        int i=n-1;
        while(i>1){
            System.out.println("i "+i);
            int parent = i/2;
            if(arr[i]>arr[parent]){
                swapForHeapiFy(arr[i],arr[parent]);
            }
            i = parent;
        }
    }
    public static void deleteFromMaxHeap(TreeNode root, int value){
        levelOrderTraversal(root);
        System.out.println(treeNodeList);
        int[] arr = new int[treeNodeList.size()+1];
        int n = treeNodeList.size();
        for(int i=1;i<n;i++) arr[i] =treeNodeList.get(i-1);
        for(int i=1;i<n;i++) System.out.print(arr[i]+", ");
        arr[1] = arr[n];
        n = n-1;
        int i =1;
        while(i<n){
            int left = arr[i*2];
            int right = arr[(i*2)+1];
            int larger = left > right?2*i:(2*i)+1;
            if(arr[i]<arr[larger]){
                swapForHeapiFy(arr[i], arr[larger]);
                i = larger;
            }
            else return;
        }
    }

    private static void swapForHeapiFy(int a, int b) {
        int temp = a;
        a =b;
        b=temp;
    }

    public static void levelOrderTraversal(TreeNode root){
        int height = calculateHeight(root);
        for(int i=1;i<=height;i++){
            currentLevel(root, i);
        }
    }

    private static void currentLevel(TreeNode root, int level) {
        if(root == null) return;
        if(level == 1) treeNodeList.add(root.val);
        else if(level >1){
            currentLevel(root.left, level-1);
            currentLevel(root.right, level-1);
        }
    }
    private static int calculateHeight(TreeNode root) {
        if(root==null) return 0;
        else{
            int lHeight = calculateHeight(root.left);
            int rHeight = calculateHeight(root.right);
            if(lHeight > rHeight) return lHeight+1;
            else return rHeight+1;
        }
    }
    // heapify - to max heap
    public static void buildHeap(int[] arr){
        int n = arr.length;
        for(int i=n/2;i>=1;i--){
            heapify(arr, i, n);
        }
    }

    private static void heapify(int[] arr, int i, int n) {
        int largest = i;
        int left = 2*i;
        int right = 2*i +1;
        if(left<=n && arr[left]>arr[largest]) largest =left;
        if(right<=n && arr[right]>arr[largest]) largest =right;
        if(i !=largest){
            swapForHeapiFy(arr[largest],arr[i]);
            heapify(arr, largest,n);
        }
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
