package com.prep;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n =6;
        System.out.println(isPowerOfTwo1(n));
    }

    private static boolean isPowerOfTwo1(int n) {
        if(n==1) return true;
        if(n%2 !=0) return false;
        return isPowerOfTwo1(n/2);
    }
}
