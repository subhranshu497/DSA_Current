package com.prep;

public class MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
        int [] nums = {0,1,0};
        int k = 1;
        int countFlip = minKBitFlips(nums, k);
    }

    private static int minKBitFlips(int[] nums, int k) {
        int flipCount=0;
        int times =0;
        for(int i=0;i<nums.length;i++){
            if(i>=k){
                if(nums[i-k]>1){
                    times--;
                    nums[i-k] -=2;
                }
            }
            if((nums[i]==1 && times%2==1)||(nums[i]==0 && times %2==0)){
                if((i-k)>1){
                    return -1;
                }
                times++;
                flipCount++;
                nums[i] +=2;
            }
        }
        if(nums[nums.length-k]>1)nums[nums.length-k] -=2;
        return flipCount;
    }
}
