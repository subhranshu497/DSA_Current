package com.prep;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;
        int maxDist = maxDistance(position, m);
        System.out.println(maxDist);
    }

    private static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int ans=0;
        int start = 0;
        int end = position[position.length-1];
        while (start<=end){
            int mid = start +(end-start)/2;
            if(isPlacementPossible(position, mid,m)){
                ans = mid;
                start = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }

    private static boolean isPlacementPossible(int[] position, int mid, int m) {
        int count =1;
        int last = position[0];
        for(int i=0;i<position.length;i++){
            if(position[i]-last >=mid){
                last = position[i];
                count++;
            }
        }
        return count>=m;
    }
}
