package com.prep.Backtracking1;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition1(s);
        for(List<String> l:result) {
            System.out.println(l);
        }
    }

    private static List<List<String>> partition1(String s) {
        List<List<String>> result = new ArrayList<>();
        palliPartitionBacktracking(new ArrayList<>(), result, s,0);
        return result;
    }

    private static void palliPartitionBacktracking(List<String> ds, List<List<String>> result, String s, int idx) {
        //base condition
        if(idx >= s.length()){
            result.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPallindrome(s,idx,i)){
                ds.add(s.substring(idx, i+1));
                palliPartitionBacktracking(ds,result,s,i+1);
                ds.remove(ds.size()-1);
            }
        }
    }


    private static boolean isPallindrome(String s, int i, int j) {
        while(i<j){
            if(s.charAt(i) !=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
