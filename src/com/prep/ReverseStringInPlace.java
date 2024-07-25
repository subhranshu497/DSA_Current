package com.prep;

public class ReverseStringInPlace {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        char[]t = reverseString(s);
        for(char c:t) System.out.print(c+", ");
    }

    private static char[] reverseString(char[] s) {
        int n = s.length;
        int left =0;
        int right =n-1;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] =temp;
            left++;
            right--;
        }
        return s;
    }
}
