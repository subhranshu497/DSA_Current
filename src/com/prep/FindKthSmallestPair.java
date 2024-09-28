package com.prep;

import java.util.Arrays;

public class FindKthSmallestPair {
    public static void main(String[] args) {
        int[] nums = {1,6,1};
        int k = 3;
        int ans = kthSmallestDistPair(nums, k);
        System.out.println(ans);
    }

    private static int kthSmallestDistPair(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int result =0;
        //do binary search for the pair distance interval
        int low = 0;
        int high = nums[n-1]-nums[0];
        while(low <=high){
            int mid = low+(high-low)/2;
            int pairCount = pairCountforFindingKthSmallest(nums, mid);
            if(pairCount < k){
                low=mid+1;
            }
            else {
                result=mid;
                high = mid-1;
            }
        }
        return result;
    }

    private static int pairCountforFindingKthSmallest(int[] nums, int dist) {
        int left =0;
        int right =left+1;
        int pairCount =0;
        while (right < nums.length){
            while (nums[right]-nums[left] >dist)left++;
            pairCount +=right-left;
            right++;
        }
        return pairCount;
    }
}
