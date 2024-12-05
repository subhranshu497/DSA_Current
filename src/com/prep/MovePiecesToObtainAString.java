package com.prep;

public class MovePiecesToObtainAString {
    public static void main(String[] args) {
        String source = "_L__R__R_";
        String target = "L______RR";
        boolean flag = canChange(source, target);
    }

    private static boolean canChange(String source, String target) {
        int n = source.length();
        int i = 0;
        int j = 0;
        while (i <n || j<n){
            while(i<n && source.charAt(i)=='_')i++;
            while(j<n && target.charAt(j)=='_')j++;
            if(i==n || j==n) return i==n && j==n;
            if(source.charAt(i) != target.charAt(j)) return false;
            if(source.charAt(i)=='R' && i>j) return false;
            if(source.charAt(i)=='L' && i<j) return false;
            i++;
            j++;
        }
        return true;
    }
}
