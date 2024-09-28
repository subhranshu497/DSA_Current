package com.prep.dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int [] nums = {0,1,0,3,2,3};
        int len = LISDP(nums);
        System.out.println(len);
    }

    /**
     * since it is problem of subsequence, so we have two option Take or Skip
     * while taking, check it should be greater than its prev element
     * So here we have to keep track of previous element as well
     * so , here are two variable , so take to dimensional Memo array
     * @param nums
     * @return
     */
    private static int LISUsingMemo(int[] nums) {
        int [][] memo = new int[nums.length+1][nums.length+1];
        for(int [] arr :memo){
            Arrays.fill(arr, -1);
        }
//        //print memo
//        for(int[] arr:memo){
//            for(int i:arr){
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }
        return solveLISUsingMemo(0, -1, nums, memo);
    }

    private static int solveLISUsingMemo(int curr, int prev, int[] nums, int [][] memo) {
        //base condition
        if(curr >= nums.length) return 0;
        if(prev != -1 && memo[prev][curr] != -1) return memo[prev][curr];
        //check for take
        int take=0;
        if(prev == -1 || nums[prev]<nums[curr]){
             take = 1+solveLISUsingMemo(curr+1, curr,nums, memo);
        }
        //in case of Skip
        int skip = solveLISUsingMemo(curr+1, prev, nums, memo);
        if(prev !=-1)memo[prev][curr] = Math.max(take, skip);
        return Math.max(take, skip);
    }
    private static int LISDP(int [] nums){
        int n = nums.length;
        int [] dp = new int[n];
        //at the staring each element is a subsequence , so fill the dp with 1
        Arrays.fill(dp,1);
        //start the iteration with two variable i, j
        //i =0 and j=0
        int i=0;
        while(i<n){
            int j =0;
            while (j !=i){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                j++;
            }
            i++;
        }
        //iterate dp array
        int len =0;
        for(int num:dp){
            System.out.print(num+", ");
            len = Math.max(len, num);
        }
        return len;
    }
}
