package com.prep;

public class SeparateBlackAndWhiteBalls {
    public static void main(String[] args) {
        String s = "100";
        long steps = minimumSteps(s);
        System.out.println(steps);
    }

    private static long minimumSteps(String s) {
        int n = s.length();
        long count =0;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0')ans +=count;
            else count++;
        }

        return ans;
    }
}
