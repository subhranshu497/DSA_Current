package com.prep;

public class UglynumberII {
    public static void main(String[] args) {
        int n =10;
        int num = nthUglyNum(n);
        System.out.println(num);
    }

    private static int nthUglyNum(int n) {
        int [] dp = new int[n+1];
        dp[1] = 1;
        int i2= 1;
        int i3 = 1;
        int i5=1;
        for(int i=2;i<=n;i++){
            int minUgly = Math.min(Math.min(dp[i2]*2, dp[i3]*3), dp[i5]*5);
            dp[i] =minUgly;
            if(dp[i2]*2== minUgly)i2++;
            if(dp[i3]*3 == minUgly)i3++;
            if(dp[i5]*5 == minUgly)i5++;
        }
        return dp[n];
    }
}
