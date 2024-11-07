package com.prep.Backtracking1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    private static List<String> result = new ArrayList<>();
    private static Map<Character, String> map = new HashMap<>();
    public static void main(String[] args) {
        String digits = "23";
        result = letterCombinations1(digits);
        System.out.println(result);
    }

    private static List<String> letterCombinations1(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if(digits.length()==0) return result;
        solveLetterCom(0,digits, new StringBuilder());
        return result;
    }

    private static void solveLetterCom(int idx, String s, StringBuilder sb) {
        //base condition
        if(idx==s.length()){
            result.add(sb.toString());
            return;
        }
        String str = map.get(s.charAt(idx));
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            sb.append(ch);
            solveLetterCom(idx+1,s,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
