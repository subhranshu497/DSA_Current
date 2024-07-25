package com.prep;

import java.util.LinkedList;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "112";
        int k = 1;
        System.out.println(rmKDigits(num, k));
    }

    private static String rmKDigits(String num, int k) {
        if(k == num.length()) return "0";
        LinkedList<Character> list = new LinkedList<>();
        for(char digit: num.toCharArray()){
            while(list.size()>0 && k>0 && list.peekLast()>digit){
                list.removeLast();
                k -=1;
            }
            list.addLast(digit);
        }
        for(int i=0; i<k; ++i) {
            list.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while(!list.isEmpty()){
            if(sb.length()==1)leadingZero = false;
            if(leadingZero && list.peekFirst()=='0'){
                list.removeFirst();
                continue;
            }
            sb.append(list.getFirst());
            list.removeFirst();
        }
        if(sb.length()==0) return "0";
        return sb.toString();
    }
}
