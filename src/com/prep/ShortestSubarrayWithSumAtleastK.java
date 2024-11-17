package com.prep;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestSubarrayWithSumAtleastK {
    public static void main(String[] args) {
        int [] nums = {2,-1,2};
        int k = 3;
        int len = shortestSubarray(nums, k);
        System.out.println(len);
    }

    private static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int j = 0;
        Deque<Integer> dq = new LinkedList<>();
        long [] cumSum = new long[n];
        while(j < n){
            if(j==0){
                cumSum[j] = nums[j];
            }else {
                cumSum[j] = cumSum[j-1]+nums[j];
            }
            if(cumSum[j] >=k){
                ans = Math.min(ans, j+1);
            }
            while (!dq.isEmpty() && cumSum[j] <= cumSum[dq.peekLast()])
                dq.removeLast();
            while(!dq.isEmpty() && cumSum[j]-cumSum[dq.peekFirst()] >=k){
                ans = Math.min(ans, j-dq.peekFirst());
                dq.pollFirst();
            }
            dq.addLast(j);
            j++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
