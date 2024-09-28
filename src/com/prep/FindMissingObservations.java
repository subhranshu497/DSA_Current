package com.prep;

public class FindMissingObservations {
    public static void main(String[] args) {
        int [] rolls = {1,2,3,4};
        int mean =6;
        int n =4;
        int [] result = new int[n];
        result = missingRolls(rolls, mean, n);
        for(int num :result) System.out.print(num+", ");
    }

    private static int[] missingRolls(int[] rolls, int mean, int n) {
        int [] result = new int[n];
        int m = rolls.length;
        int prod = mean*(m+n);
        int sum =0;
        for(int i=0;i<m;i++)sum +=rolls[i];
        int missingRollsSum =0;
        missingRollsSum =prod-sum;
        if(missingRollsSum>(6*n)) return new int[0];
        int max =6;
        int min =1;
        int i=0;
        while(missingRollsSum>0){
            if((missingRollsSum-max)>=(n-1)){
                result[i] =max;
                missingRollsSum -=max;
            }
            else if((missingRollsSum-min)>=(n-1)){
                result[i] =min;
                missingRollsSum -=min;
            }
            n--;
            i++;
        }
        return result;
    }
}
