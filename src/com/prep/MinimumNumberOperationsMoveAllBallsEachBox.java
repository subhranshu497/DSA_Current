package com.prep;

public class MinimumNumberOperationsMoveAllBallsEachBox {
    public static void main(String[] args) {
        String boxes = "110";
        int [] res = minOperations1(boxes);
        for(int num:res)
            System.out.print(res+", ");
    }

    private static int[] minOperations1(String boxes) {
        int n = boxes.length();
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            char ch = boxes.charAt(i);
            int j =0;
            int num =0;
            while(j < n){
                char ch1 = boxes.charAt(j);
                if(ch1 == '1'){
                    num += Math.abs(j-i);
                }
                j++;
            }
            res[i] = num;
        }
        return res;
    }
}
