package com.prep;

public class GreatestCommonDiviser {
    public static void main(String[] args) {
        int num1 = 24;
        int num2 = 18;
        System.out.println(gcd(num1, num2));
    }

    private static int gcd(int num1, int num2) {
        if(num1 % num2 == 0) return num2;
        return gcd(num2, num1%num2);
    }
}
