package com.prep;

public class PatchingArray {
    public static void main(String[] args) {
        int [] nums = {1,5, 10};
        int n = 20;
        int count = minPatches(nums,n);
        System.out.println(count);
    }

    /**
     * reach =0 , n=20, i=0, 1<=1, reach = 1
     * i=1, reach =1, 5<=2 no, else reach = 3, count =1
     * i=2, 10 <=4 no reach = 3+4=7, count =2
     * i=3,
     */

    private static int minPatches(int[] nums, int n) {
        long reach =0;
        int count=0;
        int i=0;
        while(reach < n){
            if(i>=nums.length){
                reach +=reach+1;
                count++;
            }else if(i<nums.length && nums[i]<=(reach+1)){
                reach +=nums[i];
                i++;
            }
            else{
                reach +=reach+1;
                count++;
            }
        }
        return count;
    }
}
