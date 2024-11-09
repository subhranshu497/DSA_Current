package com.prep;

public class MinimumArrayEnd {
    public static void main(String[] args) {
        int n =3;
        int x = 4;
        long ans= minEnd(n,x);
        System.out.println(ans);
    }

    private static long minEnd(int n, int x) {
        int i =1;
        long num = x;
        while(i <n){
           num = (num+1)|x;
           i++;
        }
        return num;
    }
}
