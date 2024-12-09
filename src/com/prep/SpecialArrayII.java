package com.prep;

import java.util.Arrays;

public class SpecialArrayII {
    public static void main(String[] args) {
        int [] nums = {4,3,1,6};
        int [][] queries = {{0,2},{2,3}};
        Arrays.sort(queries,(a,b)->a[0]-b[0]);
        boolean [] res = isArraySpecialII(nums, queries);
        for(boolean flag : res)
            System.out.println(flag);
    }

    private static boolean[] isArraySpecialII(int[] nums, int[][] queries) {
        boolean [] result = new boolean[queries.length];
        int idx =0;
        for(int [] arr:queries){
            int start = arr[0];
            int end = arr[1];
            boolean flag =true;
            for(int i=start+1;i<=end;i++){
                if((nums[i-1]%2==0 && nums[i]%2 !=0)||(nums[i-1]%2 !=0 && nums[i]%2 ==0))continue;
                else  flag =false;
            }
            result[idx] = flag;
            idx++;
        }
        return result;
    }
}
