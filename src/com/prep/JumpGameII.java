package com.prep;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int totalJumps = jumpII(nums);
    }

    private static int jumpII(int[] nums) {
        int destination = nums.length-1;
        int totalJumps=0;
        int coverage=0;
        int lastJumpIndex=0;
        if(nums.length ==1) return 0;
        for(int i=0;i< nums.length;i++){
            coverage = Math.max(coverage, i+nums[i]);
            if(i==lastJumpIndex){
                lastJumpIndex = coverage;
                totalJumps++;
                if(coverage==destination)return totalJumps;
            }

        }
        return totalJumps;
    }
}
