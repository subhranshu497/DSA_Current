package com.prep;

public class DeleteCharactersToMakeFancyString {
    public static void main(String[] args) {
        String s = "aaabaaaa";
        String str = fancyString(s);
        System.out.println(str);
    }

    private static String fancyString(String s) {
        if(s.length()==1 || s.length()==2) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for(int i=2;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1) && s.charAt(i)==s.charAt(i-2) && s.charAt(i-1)==s.charAt(i-2))continue;
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
