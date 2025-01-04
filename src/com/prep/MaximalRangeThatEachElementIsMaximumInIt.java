package com.prep;

import java.util.Stack;

public class MaximalRangeThatEachElementIsMaximumInIt {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int [] ans = maximumLengthOfRanges(nums);
        for(int num:ans)
            System.out.print(num+", ");
    }

    private static int[] maximumLengthOfRanges(int[] nums) {
        int n = nums.length;
        int [] ans = new int [n];
        for(int i=0;i<n;i++){
            Stack<Integer> st = new Stack<>();
            int left =i;
            int right =i;
            st.push(nums[i]);
            while(left >=0){
                if(left==i){
                    left--;
                    continue;
                }
                else if(nums[i]>=nums[left]){
                    st.push(nums[left]);
                    left--;
                }
                else break;
            }
            while(right <n){
                if(right==i){
                    right++;
                    continue;
                }
                else if(nums[i]>=nums[right]){
                    st.push(nums[right]);
                    right++;
                }
                else break;
            }
            ans[i] = st.size();
        }
        return ans;
    }
}
