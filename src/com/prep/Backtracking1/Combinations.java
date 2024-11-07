package com.prep.Backtracking1;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        result = combine1(n,k);
        for(List<Integer> l:result)
            System.out.println(l);
    }

    private static List<List<Integer>> combine1(int n, int k) {

        solveCombine(1, n,k,new ArrayList<>());
        return result;
    }

    private static void solveCombine(int i, int n, int k,  List<Integer> temp) {
        //base condition
        if(k==0){
            result.add(new ArrayList<>(temp));
            return ;
        }
        if(i >n)return;
        //add
        temp.add(i);
        solveCombine(i+1,n,k-1,temp);
        //remove for backtracking
        temp.remove(temp.size()-1);
        //skip
        solveCombine(i+1,n,k,temp);
    }
}
