package com.prep;

public class MinimumDeletionsMakeStringBalanced {
    public static void main(String[] args) {
        String s = "aababbab";
        int count = minDelStrBal(s);
        System.out.println(count);
    }

    private static int minDelStrBal(String s) {
        int countB= s.charAt(0)=='b'?1:0;
        int res =0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='b'){
                countB++;
            }
            else if(countB !=0 && s.charAt(i)=='a'){
                res++;
                countB--;
            }
        }
        return res;
    }
}
