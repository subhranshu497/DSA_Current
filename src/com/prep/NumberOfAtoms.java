package com.prep;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtoms {
    public static void main(String[] args) {
        String formula ="K4(ON(SeO3)2K)2";
        String newFormula = countOfAtoms(formula);
        System.out.println(newFormula);
    }

    private static String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> st = new Stack<>();
        st.push(new HashMap<>());
        int i=0;
        while (i<n){
            if(formula.charAt(i)=='('){
                st.push(new HashMap<>());
                i++;
            }
            else if(formula.charAt(i)==')'){
                Map<String, Integer> currMapClose = st.peek();
                Map<String, Integer> newMapClose = new HashMap<>();
                st.pop();
                i++;
                String multiplier ="";
                while(i<n && Character.isDigit(formula.charAt(i))){
                    multiplier +=formula.charAt(i);
                    i++;
                }
                if(!multiplier.isEmpty()){
                    int multiplierInt = Integer.parseInt(multiplier);
                    for(Map.Entry<String, Integer> e:currMapClose.entrySet()){
                        String key = e.getKey();
                        Integer val = e.getValue();
                        int newVal = val * multiplierInt;
                        newMapClose.put(key, newVal);
                    }
                    //st.push(newMapClose);
                    Map<String, Integer> mergeMap = st.pop();
                    for(Map.Entry<String, Integer> e : newMapClose.entrySet()){
                        String key=e.getKey();
                        Integer val = e.getValue();
                        if(mergeMap.containsKey(key)){
                            int newVal = val +mergeMap.get(key);
                            mergeMap.put(key, newVal);
                        }
                        else mergeMap.put(key, val);
                    }
                }
            }
            else{
                String currElememnt = "";
                currElememnt +=formula.charAt(i);
                i++;
                //check for the lowercase post upercase letter , e.g. He or Mg
                while(i<n && Character.isLetter(formula.charAt(i)) && Character.isLowerCase(formula.charAt(i))){
                    currElememnt +=formula.charAt(i);
                    i++;
                }
                //check for digits post finding of alphabet
                String currentCount="";
                while(i<n && Character.isDigit(formula.charAt(i))){
                    currentCount +=formula.charAt(i);
                    i++;
                }
                //make an entry to map and then stack
                int currCount = Integer.parseInt(currentCount.isEmpty()?"1":currentCount);
                Map<String, Integer> currMap = st.peek();
                st.pop();
                if(currMap.containsKey(currElememnt)){
                    int currKey = currMap.get(currElememnt);
                    currCount +=currKey;
                    currMap.put(currElememnt,currCount);
                }
                else{
                    currMap.put(currElememnt,currCount);
                }
                st.push(currMap);
            }
        }
        System.out.println(st.peek());
        Map<String, Integer> sortedMap = new TreeMap<>();
        while(!st.isEmpty()){
            Map<String, Integer> map = st.pop();
            for(Map.Entry<String, Integer> e:map.entrySet()){
                String key = e.getKey();
                Integer val = e.getValue();
                if(sortedMap.containsKey(key)){
                    int sortedMapVal = sortedMap.get(key);
                    int finalVal = sortedMapVal+val;
                    sortedMap.put(key, finalVal);
                }
                else{
                    sortedMap.put(key, val);
                }
            }
        }
        System.out.println(sortedMap);




        String modifiedFormula ="";
//        for(Map.Entry<String, Integer> e:sortedMap.entrySet()){
//            String key = e.getKey();
//            Integer val = e.getValue();
//            String strVal = String.valueOf(val);
//           modifiedFormula +=key;
//           modifiedFormula +=strVal;
//        }
        return modifiedFormula;
    }
    private static boolean isNumber(char ch){
        return ch=='0'||ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9';
    }
    //alphabet checker
    private static boolean isAlphabet(char ch){
        return Character.isLetter(ch);
    }
}
