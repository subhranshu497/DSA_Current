package com.prep;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {
    public static void main(String[] args) {
        int [] nums = {3,1,4,2};
        int p = 6;
        int len = makeSumDivByP(nums,p);
        System.out.println(len);
    }

    private static int makeSumDivByP(int[] nums, int p) {
        int n = nums.length;;
        int sum = 0;
        for(int num : nums){
            sum = (sum+num)%p;
        }
        int target = sum % p;
        if(target==0) return 0;
        //map <curr%p ,j>
        Map<Integer, Integer> map = new HashMap<>();
        int curr =0;
        map.put(0, -1);
        int result =Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            curr = (curr+nums[j])%p;
            int search = (curr-target+p)%p;
            if(map.containsKey(search)){
                result = Math.min(result, j-map.get(search));
            }
            map.put(curr,j);
        }
        return result==n?-1:result;
    }
}
