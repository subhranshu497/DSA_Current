package com.prep;

public class SpecialArrayI {
    public static void main(String[] args) {
        int [] nums = {4,3,1,6};
        boolean flag = isArraySpecial(nums);
        System.out.println(flag);
    }

    private static boolean isArraySpecial(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if((nums[i-1]%2==0 && nums[i]%2 !=0)||(nums[i-1]%2 !=0 && nums[i]%2 ==0))continue;
            else return false;
        }
        return true;
    }
}
