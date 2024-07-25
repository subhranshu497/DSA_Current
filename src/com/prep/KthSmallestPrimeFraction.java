package com.prep;

import java.util.*;

public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        //System.out.println((float)arr[0]/arr[1]);
        int k =3;
        int[] result =kthSmallestPrimeFractionBinarySearch(arr, k);
        System.out.println(result[0]+", "+result[1]);
    }
    private static int[] kthSmallestPrimeFractionBinarySearch(int[] arr, int k) {
        double min =(double) arr[0]/arr[arr.length-1];
        double max = 1.0;
        while(min < max){
            double mid = (min+max)/2;
            int [] count = helperF(arr, mid);
            if(k<count[0])max = mid;
            else if(k>count[0]) min = mid;
            else return new int[]{count[1], count[2]};
        }
        return null;
    }

    private static int[] helperF(int[] arr, double mid) {
        int count =0;
        int i=0;
        int n = arr.length;
        int num=arr[0], deno = arr[n-1];
        for(int j=1;j<n;j++){
            while (arr[i]<=arr[j]*mid)i++;
            count +=i;
            if(i>0 && arr[i-1]*deno >arr[j]*num){
                num = arr[i-1];
                deno = arr[j];
            }
        }
        return new int[]{count, num, deno};
    }


    //Brute force approach - gives TLE
    private static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Map<Float,List<Integer>> map = new HashMap<>();
        List<Float> fractionList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j< arr.length;j++){
                float fraction = (float)arr[i] / arr[j];
                fractionList.add(fraction);
                map.putIfAbsent(fraction, new ArrayList<>());
                map.get(fraction).add(arr[i]);
                map.get(fraction).add(arr[j]);
            }
        }
        Collections.sort(fractionList);
        float key =fractionList.get(k-1);
        List<Integer> result = map.get(key);
        int [] resultArr = new int[2];
        resultArr[0]=result.get(0);
        resultArr[1]=result.get(1);
        return resultArr;
    }
}
