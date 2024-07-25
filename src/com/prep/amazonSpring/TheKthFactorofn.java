package com.prep.amazonSpring;

import java.util.ArrayList;
import java.util.List;

public class TheKthFactorofn {
    public static void main(String[] args) {
        int n =4;
        int k =4;
        int kth = kthFactor(n,k);
        System.out.println(kth);
    }

    private static int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i==0)list.add(i);
        }
        return k<=list.size()?list.get(k-1):-1;
    }
}
