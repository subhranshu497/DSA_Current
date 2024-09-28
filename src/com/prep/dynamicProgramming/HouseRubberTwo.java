package com.prep.dynamicProgramming;

import java.util.Arrays;

public class HouseRubberTwo {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        int money = houseRubberII(nums);
        System.out.println(money);
    }

    /**
     * this problem is quite similar as house rubber probem
     * only thing we have to take care here is , first calculate house 0, n-2 and then 1 , n-1
     * then return the max of two
     * @param nums
     * @return
     */
    private static int houseRubberII(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int dp[] = new int[n+1];
        dp[0] =0;
        int cashskipFirst =0;
        int cashStealFirst =0;
        // we have to callute two different value by skipping and taking the 0th house
        //while stealing from first house
        for(int i=1;i<= n-1;i++){
            int steal = nums[i-1]+(i-2 >=0?dp[i-2]:0);
            int skip = dp[i-1];
            dp[i] = Math.max(steal, skip);
        }
        cashskipFirst =dp[n-1];
        Arrays.fill(dp,0);
        for(int i=2;i<= n;i++){
            int steal = nums[i-1]+dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(steal, skip);
        }
        cashStealFirst = dp[n];
        return Math.max(cashskipFirst, cashStealFirst);
    }
}
