package com.prep.dstc.heap;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        int[] result = heapSortCode(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+", ");
        }
    }

    private static int[] heapSortCode(int[] arr) {
        int n = arr.length;
        //build heap
        buildHeapForHeapSort(arr,n);
        for(int i=n-1;i>0;i--){
            swapForHeapSort(arr[i],arr[n-1]);
            heapifyForHeapSort(arr, i-1,n);
        }
        return arr;
    }

    private static void buildHeapForHeapSort(int[] arr, int n) {
        for(int i=n/2 - 1;i>=0;i--){
            heapifyForHeapSort(arr,i,n);
        }
    }

    private static void heapifyForHeapSort(int[] arr, int i, int n) {
        int largest = i;
        int left = 2*i+1;
        int right = (2*i)+2;
        if(left<n && arr[left]>arr[largest]) largest = left;
        if(right<n && arr[right]>arr[largest]) largest = right;
        if(i !=largest){
            swapForHeapSort(arr[i],arr[largest]);
            heapifyForHeapSort(arr,largest,n);
        }
    }

    private static void swapForHeapSort(int a, int b) {
        int temp =a;
        a =b;
        b=temp;
    }
}
