package com.prep;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    private static int trap(int[] height) {
        int[]left = new int[height.length];
        int[]right = new int[height.length];
        int result =0;
        left[0]=height[0];
        right[height.length-1]=height[height.length-1];
        for(int i=1;i< height.length;i++){
            left[i]= Math.max(height[i],left[i-1]);
        }
        for(int i= height.length-2;i>= 0;i--){
            right[i]= Math.max(height[i],right[i+1]);
        }
        //find result
        for(int i=0;i< height.length;i++){
            result += Math.min(left[i],right[i])-height[i];
        }
        return result;
    }
}
