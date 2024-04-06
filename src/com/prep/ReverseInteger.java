package com.prep;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverseInt(x));
    }

    private static int reverseInt(int x) {
        int rev=0;
        while(x !=0){
            int rem = x%10;
            if(rev >Integer.MAX_VALUE/10 || rev <Integer.MIN_VALUE/10)return 0;
            rev = (rev*10)+rem;
            x /=10;
        }
        return rev;
    }
}
