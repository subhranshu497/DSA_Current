package com.prep.hackerRank.RecursionBackTracking;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
