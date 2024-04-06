package com.prep;

public class FindPivotInteger {
    public static void main(String[] args) {
        int n =8;
        System.out.println(findPivot(n));
    }

    private static int findPivot(int n) {
        if(n==1) return 1;
        int left =0;
        int right = n;
        int sum1 =left;
        int sum2 =right;
        while(left <right){
            if(sum2>sum1){
                ++left;
                sum1 +=left;
            }
            else{
                --right;
                sum2 +=right;
            }
            if (sum1 == sum2 && left + 1 == right - 1) {
                return left + 1;
            }
        }
        return -1;
    }
}
