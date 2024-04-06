package com.prep.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {
    public static void main(String[] args) {
        int n=2;
        List<List<Integer>> queries = new ArrayList<>();
        List<Integer> result = dArray(n, queries);
    }

    private static List<Integer> dArray(int n, List<List<Integer>> queries) {
        List<List<Integer>>arr = new ArrayList<>();
        int la=0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> res = new ArrayList<>();
            arr.add(res);
        }
        for(int i=0;i< queries.size();i++){
            int idx = (queries.get(i).get(1) ^ la)%n;
            if(queries.get(i).get(0)==1){
                arr.get(idx).add(queries.get(i).get(2));
            }
            else{
                la = arr.get(idx).get(queries.get(i).get(2)%arr.get(idx).size());
                ans.add(la);
            }
        }
        return ans;
    }
}
