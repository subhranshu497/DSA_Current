package com.prep;

public class RangeAddition {
    public static void main(String[] args) {
        int [][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        int length =5;
        int [] res = getModifiedArray(length, updates);
        for(int r:res)
            System.out.println(r);
    }

    //difference array technique
    private static int[] getModifiedArray(int length, int[][] updates) {
        int [] arr = new int[length];
        for(int [] update:updates){
            int start = update[0];
            int end = update[1];
            int val = update[2];
            arr[start] +=val;
            if(end+1 < length)
                arr[end+1] -=val;
        }
        //cumulatiove sum
        int cumSum =0;
        for(int i=1;i<length;i++){
            arr[i] +=arr[i-1];
        }
        return arr;
    }
}
