package com.prep;

public class FindKthBitInNthBinaryString {
    public static void main(String[] args) {
        int n = 3, k = 1;
        char ch = findKthBit(n,k);
        System.out.println(ch);
    }

    private static char findKthBit(int n, int k) {
        //base case
        if(n==1) return '0';
        int len = (int) (Math.pow(2,n)-1);
        if(k < Math.ceilDiv(len,2))
            return findKthBit(n-1,k);

        else if(k == Math.ceilDiv(len,2))
            return '1';
        else {
            char ch = findKthBit(n-1 ,len-(k-1));
            return ch=='1'?'0':'1';
        }
    }
}
