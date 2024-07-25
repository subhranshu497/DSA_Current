package com.prep;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    private static int trap(int[] height) {
        int n=height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int result=0;
        left[0] = height[0];
        //form left array
        for(int i=1;i<n;i++){
            left[i] = Math.max(height[i],left[i-1]);
        }
        right[n-1] =height[n-1];
        //form right array
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(height[i],right[i+1]);
        }
        //calculate result
        for(int i=0;i<n;i++){
            result +=Math.min(left[i],right[i])-height[i];
        }
        return result;
    }
}
