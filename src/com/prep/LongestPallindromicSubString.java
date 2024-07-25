package com.prep;

public class LongestPallindromicSubString {
    public static void main(String[] args) {
        String s = "babad";
        String result =longestPalindrome(s);
    }

    private static String longestPalindrome(String s) {
        if(s.length()==1) return s;
        String lps="";
       for(int i=1;i<s.length();i++){
           //for odd length string
           int low =i;
           int high =i;
           while(s.charAt(low)==s.charAt(high)){
               low--;
               high++;
               if(low ==-1 || high ==s.length()) break;
           }
           String palli = s.substring(low+1,high);
           if(palli.length()>lps.length()) lps = palli;
           //for even length string
            low =i-1;
            high =i;
           while(s.charAt(low)==s.charAt(high)){
               low--;
               high++;
               if(low ==-1 || high ==s.length()) break;
           }
            palli = s.substring(low+1,high);
           if(palli.length()>lps.length()) lps = palli;
       }
return lps;
    }
}
