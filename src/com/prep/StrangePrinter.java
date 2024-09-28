package com.prep;

import java.util.Arrays;

public class StrangePrinter {
    public static int[][] t;
    public static void main(String[] args) {
        String s = "aba";
        int rep = strPtr(s);
        System.out.println(rep);
    }

    private static int strPtr(String s) {
        int n = s.length();
        t = new int[n][n + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);
        return solveStrPtr(0,n-1,s);
    }

    private static int solveStrPtr(int l, int r, String s) {
        if(l==r)return 1;
        if(l>r)return 0;
        if (t[l][r] != -1)
            return t[l][r];
        int i =l+1;
        while(i<=r && s.charAt(i)==s.charAt(l)) i++;
        if(i == r+1) return 1;
        int first = 1+solveStrPtr(i,r,s);
        int second = Integer.MAX_VALUE;
        for(int j=i;j<=r;j++){
            if(s.charAt(j)==s.charAt(l)){
                int ans = solveStrPtr(i,j-1,s)+solveStrPtr(j,r,s);
                second = Math.min(ans, second);
            }
        }
        return t[l][r] = Math.min(first, second);
    }
}
