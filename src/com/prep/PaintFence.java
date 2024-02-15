package com.prep;

public class PaintFence {
    public static void main(String[] args) {
        int n =1;
        int k=2;
        System.out.println(numWays(n,k));
    }

    private static int numWays(int n, int k) {
        if(n==1)
            if(k==1)return 1;
            else return k;
        return (int) ((Math.pow(n,k))-n);
    }
}
