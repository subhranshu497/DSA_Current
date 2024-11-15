package com.prep;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static void main(String[] args) {
        int [] arr = {1,2,3,10,4,2,3,5};
        int len = findLengthOfShortestSubarray(arr);
        System.out.println(len);
    }

    private static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int right = n-1;
        while(right >0 && arr[right] >= arr[right-1])
            right--;
        int left =0;
        int ans = right;
        while(left < right && (left==0 || arr[left-1] <=arr[left])){
            while(right < n && arr[right] < arr[left])
                right++;
            ans = Math.min(ans, right-left-1);
            left++;
        }
        return ans;
    }
}
