package com.prep;

import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {
        int[] tokens = {100,200};
        int power = 150;
        System.out.println(maxScore(tokens, power));
    }

    private static int maxScore(int[] tokens, int power) {
        int score =0;
        Arrays.sort(tokens);
        //if(tokens[0]>power) return 0;
        int left =0;
        int right=tokens.length-1;
        while(left<=right){
            if(tokens[left]<=power)
            {
                power -=tokens[left];
                score++;
                left++;
            }
            else if(left<right && score>0){
                power +=tokens[right];
                score--;
                right--;
            }
            else return score;
        }
        return score;
    }
}
