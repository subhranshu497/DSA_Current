package com.prep;

import java.util.Set;

public class FractionAdditionSubtraction {
    public static void main(String[] args) {
        String s = "-1/2+1/2";
        String result = fractionAddSub(s);
        System.out.println(result);
    }

    private static String fractionAddSub(String s) {
        int numr = 0;
        int deno =1;
        int i=0;
        int n = s.length();
        while (i<n){
            int currNumr = 0;
            int currDeno =0;
            boolean isNegative = s.charAt(i)=='-';
            if(s.charAt(i)=='+' || s.charAt(i)=='-') i++;
            //build numerator
            while(i<n && isDigitCheck(s.charAt(i))){
                int val = s.charAt(i)-'0';
                currNumr = (currNumr*10)+val;
                i++;
            }
            i++; // skip the divisor
            if(isNegative)currNumr *=-1;
            while(i<n && isDigitCheck(s.charAt(i))){
                int val = s.charAt(i)-'0';
                currDeno = (currDeno*10)+val;
                i++;
            }
            numr = (numr*currDeno)+(deno*currNumr);
            deno = deno*currDeno;
        }
        int gcd = Math.abs(gcdCalculate(numr, deno));
        numr /=gcd;
        deno /=gcd;
        String result = numr+""+"/"+deno+"";
        return result;
    }

    private static int gcdCalculate(int num1, int num2) {
        while(num2 !=0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    private static boolean isDigitCheck(char c) {
        return Set.of('1','2','3','4','5','6','7','8','9','0').contains(c);
    }
}
