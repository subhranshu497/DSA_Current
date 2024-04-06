package com.prep.hackerRank.RecursionBackTracking;

import com.prep.RemoveNthNodeFromEndOfList;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
    private static List<String> result = new ArrayList<>();
    private static String [] keys = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        String digits = "23";
        result = letterCombinations(digits);
        System.out.println(result);
    }

    private static List<String> letterCombinations(String digits) {
        dfsLetter(0,digits,new StringBuilder());
        return result;
    }

    private static void dfsLetter(int len, String digits, StringBuilder sb) {
        if(len==digits.length()){
            result.add(sb.toString());
            return;
        }
        String alphabet = keys[digits.charAt(len)-'0'];
        for(int i=0;i<alphabet.length();i++){
            sb.append(alphabet.charAt(i));
            dfsLetter(len+1,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }


}
