package com.prep;
//Leetcode # 2864
public class MaximumOddBinaryNumber {
    public static void main(String[] args) {
        String s = "010";
        System.out.println(maxOdd(s));
    }

    private static String maxOdd(String s) {
        char[] chArr = s.toCharArray();
        //count all ones
        int count =0;
        for(char c:chArr){
            if(c=='1')count++;
        }
        chArr[chArr.length-1]='1';
        count--;
        //now place all ones at MSB
        int i=0;
        for(int c=1;c<=count;c++){
            chArr[i++]='1';
        }
        //fill LSB
        for(;i<chArr.length-1;i++){
            chArr[i]='0';
        }
        return String.valueOf(chArr);
    }
}
