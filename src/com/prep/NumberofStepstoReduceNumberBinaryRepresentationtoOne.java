package com.prep;

public class NumberofStepstoReduceNumberBinaryRepresentationtoOne {
    public static void main(String[] args) {
        String s ="1101";
        int result = numSteps(s);
        System.out.println(result);
    }

    private static int numSteps(String s) {

        int n = s.length();
        int count = 0;
        int carry =0;
        for(int i=n-1;i>0;i--){
            int digit = Character.getNumericValue(s.charAt(i))+carry;
            if(digit %2==1){
                count +=2;
                carry =1;
            }
            else count++;
        }
        return count+carry;
    }
}
