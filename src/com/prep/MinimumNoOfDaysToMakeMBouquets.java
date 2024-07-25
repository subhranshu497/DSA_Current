package com.prep;

import java.util.Arrays;

public class MinimumNoOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[]bloomday = {1,10,3,10,2};
        int m = 3;
        int k=1;
        int days = minDays(bloomday,m,k);
        System.out.println(days);
    }

    private static int minDays(int[] bloomday, int m, int k) {
        int start =0;
        int end =0;
        for(int day:bloomday){
            end = Math.max(end, day);
        }
        int minDays=-1;
        while(start <=end){
            int mid = (start+end)/2;
            if(getNoOBouquet(bloomday,mid,k)>=m){
                minDays =mid;
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return minDays;
    }

    private static int getNoOBouquet(int[] bloomday, int mid, int k) {
        int numOfBouquet=0;
        int count =0;
        for(int i=0;i<bloomday.length;i++){
            if(bloomday[i]<=mid){
                count++;
            }
            else count =0;
        }
        if(count==k){
            numOfBouquet++;
            count=0;
        }
        return numOfBouquet;
    }
}
