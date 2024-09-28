package com.prep;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestLexicographicalNumbers {
    public static void main(String[] args) {
        int n = 10;
        int k =3;
        int smallest = kThSmallestLexi(n, k);
        System.out.println(smallest);
    }

    private static int kThSmallestLexi(int n, int k) {
        long current =1;
        long next =current+1;
        k -=1; // since we consider alerdy 1
        while(k> 0){
            int count = getCountKthSmallestLex(current, next, n);
            if(count <=k){
                current +=1;
                k -=count;
            }
            else {
                current *=10;
                k -=1;
            }
        }
        return (int)current;
    }

    private static int getCountKthSmallestLex(long current, long next, int n) {
        int count =0;
        while (current <=n){
            count += next -current;
            current *=10;
            next *=10;
            next = Math.min(next,(long) n+1);
        }
        return count;
    }
}
