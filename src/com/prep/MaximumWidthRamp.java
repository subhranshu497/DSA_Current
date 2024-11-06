package com.prep;

import java.util.Stack;

public class MaximumWidthRamp {
    public static void main(String[] args) {
        int [] nums = {9,8,1,0,1,9,4,0,4,1};
        int width = maxWidthRamp(nums);
        System.out.println(width);
    }

    private static int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int i =0;
        int width =0;
        while(i<n){
            if(st.isEmpty() || nums[st.peek()] > nums[i]){
                st.push(i);
            }
            i++;
        }
        for (int j = n - 1; j >= 0; --j) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[j]) {
                width = Math.max(width, j - st.pop());
            }
        }
        return width;
    }
}
