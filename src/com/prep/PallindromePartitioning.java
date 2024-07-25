package com.prep;

import java.util.ArrayList;
import java.util.List;

public class PallindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0,s,path, result);
        return result;
    }

    private static void func(int idx, String s, List<String> path, List<List<String>> result) {
        //base condition
        if(idx == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(checkPallindrome(s, idx,i)){
                path.add(s.substring(idx,i+1));
                func(i+1,s,path,result);
                path.remove(path.size()-1);
            }
        }
    }

    private static boolean checkPallindrome(String s, int start, int end){
        while (start <=end){
            if(s.charAt(start++) !=s.charAt(end--)) return false;
        }
        return true;
    }
}
