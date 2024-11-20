package com.prep;

import java.util.HashMap;
import java.util.Map;

public class NumberOfUniqueFlavorsAfterSharingKCandies {
    public static void main(String[] args) {
        int [] nums = {1,2,2,3,4,3};
        int k =3;
        int flavors = shareCandies(nums, k);
        System.out.println(flavors);
    }

    private static int shareCandies(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int candy:nums){
            map.put(candy, map.getOrDefault(candy,0)+1);
        }
        for(int i=0;i< n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)-1);
            if(map.get(nums[i])==0)
                map.remove(nums[i]);
            if(i>=k){
                map.put(nums[i-k],map.getOrDefault(nums[i-k],0)+1);
                ans = Math.max(ans, map.size());
            }
            else ans = map.size();
        }
        return ans;
    }
}
