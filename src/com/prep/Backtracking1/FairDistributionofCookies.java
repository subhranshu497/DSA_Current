package com.prep.Backtracking1;

public class FairDistributionofCookies {
    private static int unfairness = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int [] cookies = {8,15,10};
        int k =2;
        unfairness = distributeCookies(cookies, k);
        System.out.println(unfairness);
    }

    private static int distributeCookies(int[] cookies, int k) {
        //prepare a children array of length k
        int [] children = new int[k];
        solveCookies(cookies, children, k, 0);
        return unfairness;
    }

    private static void solveCookies(int[] cookies, int[] children, int k, int idx) {
        //base condition
        if(idx >=cookies.length){
            int cookie = 0;
            for(int j=0;j<k;j++){
                cookie = Math.max(cookie, children[j]);
            }
            unfairness = Math.min(unfairness, cookie);
            return;
        }
        int candy = cookies[idx];
        for(int i=0;i<k;i++){
            children[i] +=candy;
            solveCookies(cookies, children, k,idx+1);
            children[i] -=candy;
        }
    }
}
