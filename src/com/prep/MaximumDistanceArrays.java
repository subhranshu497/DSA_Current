package com.prep;

import java.util.ArrayList;
import java.util.List;

public class MaximumDistanceArrays {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(List.of(1,4)));
        arr.add(new ArrayList<>(List.of(0,5)));
        //arr.add(new ArrayList<>(List.of(1,2,3)));
        int maxDist = maxDistanceinArrayOfArray(arr);
        System.out.println(maxDist);
    }

    private static int maxDistanceinArrayOfArray(List<List<Integer>> arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int rmax=Integer.MIN_VALUE;
        int rmin=Integer.MAX_VALUE;
        int dist=0;
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.get(i).size();j++){
                if(i==0){
                    if(min>arr.get(i).get(j)) min = arr.get(i).get(j);
                    if(max<arr.get(i).get(j)) max = arr.get(i).get(j);
                }
                else{
                    if(min>arr.get(i).get(j)){
                        min = arr.get(i).get(j);
                        break;
                    }
                    else if(max<arr.get(i).get(j)){
                        max = arr.get(i).get(j);
                    }
                }
            }
            rmax = Math.max(rmax, max);
            rmin = Math.min(rmin,min);
        }
        return Math.abs(rmax-rmin);
    }
}
