package com.prep;

public class PowerXN {
    public static void main(String[] args) {
        double x = 2;
        int n =10;
        System.out.println(powerx(x,n));
    }

    private static double powerx(double x, int n) {
        double res = helper(x, Math.abs(n));
        return n<0 ? 1/res:res;
    }

    private static double helper(double x, int n) {
        //base case
        if(x == 0) return 0;
        if(n == 0) return 1;
        double res = 0;
        res = helper(x, n/2);
        res *=res;
        return res = n%2==0?res:x*res;
    }
}
