package com.prep;

public class UglyNumberIII {
    public static void main(String[] args) {
        int n = 3;
        int a =2;
        int b = 3;
        int c = 5;
        System.out.println(nthUglyNumber(n,a,b,c));
    }

    private static int nthUglyNumber(int n, int a, int b, int c) {
        int[] dp = new int[n+1];
        int min = Math.min(a, Math.min(b,c));
        int count =0;
        while(dp[n-1] ==0){
            if(min % a==0 || min % b==0 || min % c==0){
                dp[count]=min;
                count++;
            }
            min++;
        }
        return dp[n-1];
    }
}
