package com.prep;

public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
    public static void main(String[] args) {
        int[] nums= {2,1,3,4};
        int k =1;
        System.out.println(minOperation(nums,k));
    }

    private static int minOperation(int[] nums, int k) {
        int finalXor =0;
        for(int n:nums){
            finalXor ^=n;
        }
        int count =0;
        while(k >0 || finalXor >0){
            if((k%2) !=(finalXor%2)){
                count++;
            }
            k /=2;
            finalXor /=2;
        }
        return count;
    }
}
